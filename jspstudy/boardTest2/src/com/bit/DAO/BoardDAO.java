package com.bit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BoardVO;

public class BoardDAO {
	public static int pageSIZE = 5;
	// 한 화면에 보여줄 레코드의 수
	public static int totalRecord = 0;
	// 전체 레코드의 수를 저장할 변수
	public static int totalPage = 1;
	// 전체 페이지 수를 저장할 변수
	public static int pageGroup = 5;

	public int getCount() {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next())
				cnt = rs.getInt(1);

			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cnt;
	}

	public int deleteBoard(int no, String pwd) {

		int re = -1;
		String sql = "DELETE board WHERE no=? AND pwd=?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}

	public ArrayList<BoardVO> listBoard(int pageNUM) {
		totalRecord = getCount();
		totalPage = totalRecord / pageSIZE;
		if (totalRecord % pageSIZE != 0)
			totalPage++;

		int start;
		int end;

		start = (pageNUM - 1) * pageSIZE + 1;
		end = start + pageSIZE - 1;

		if (end > totalRecord)
			end = totalRecord;

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "SELECT no, title, writer, pwd, regdate, hit, content, fname, fsize, ip, b_ref, b_level, b_step "
				+ "FROM "
				+ "(SELECT rownum r, no, title, writer, pwd, regdate, hit, content, fname, fsize, ip, b_ref, b_level, b_step "
				+ "FROM " + "(SELECT * FROM board ORDER BY b_ref desc, b_step)) a " + "WHERE a.r between ? AND ?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getInt(13)));
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	public BoardVO getBoard(int no, Boolean f) {

		if (f)
			updateHit(no);

		BoardVO b = new BoardVO();
		String sql = "SELECT * FROM board WHERE no=?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPwd(rs.getString(4));
				b.setRegdate(rs.getString(5));
				b.setHit(rs.getInt(6));
				b.setContent(rs.getString(7));
				b.setFname(rs.getString(8));
				b.setFsize(rs.getInt(9));
				b.setIp(rs.getString(10));
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return b;
	}

	public int insertBoard(BoardVO b) {
		int re = -1;
		int no = getNextNo();

		String sql = "INSERT INTO board VALUES(?,?,?,?,sysdate,0,?,?,?,?,?,?,?)";

		try {
			// 일단 부모글이라고 본다
			int b_ref = no;
			int b_level = 0;
			int b_step = 0;

			// 만약에 답글이라면
			int pno = b.getNo();
			if (pno != 0) {

				// 부모글의 정보를 갖고 온다
				BoardVO p = getBoard(pno, false);

				// b_ref : 부모글의 b_ref와 동일하게 한다.
				// b_level : 부모글의 b_level+1로 설정한다.
				// b_step : 이미 달려있는 답글들의 b_step을 1씩 증가한다.
				// 부모글의 b_step+1로 설정한다.
				b_ref = p.getB_ref();
				b_level = p.getB_level();
				b_step = p.getB_step();

				// 이미달려있는 답글들의 b_step을 증가시키기 위한 메소드를 호출한다.
				updateStep(b_ref, b_step);

				b_level++;
				b_step++;

			}

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContent());
			pstmt.setString(6, b.getFname());
			pstmt.setInt(7, b.getFsize());
			pstmt.setString(8, b.getIp());
			pstmt.setInt(9, b_ref);
			pstmt.setInt(10, b_level);
			pstmt.setInt(11, b_step);

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return re;
	}

	// 이미 달려 있는 답글들의 b_step을 1증가 시킨다
	private void updateStep(int b_ref, int b_step) {
		// TODO Auto-generated method stub

		String sql = "UPDATE board SET b_step = b_step+1 WHERE b_ref=? AND b_step > ? ";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);
			pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public int getNextNo() {
		int no = 0;
		String sql = "SELECT NVL(MAX(no), 0)+1 FROM board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
				no = rs.getInt(1);

			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return no;
	}

	public int updateBoard(BoardVO b) {
		int re = -1;
		String sql = "UPDATE board SET title=?,writer=?,content=?,fname=?,fsize=?,ip=? WHERE no=? AND pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getFname());
			pstmt.setInt(5, b.getFsize());
			pstmt.setString(6, b.getIp());
			pstmt.setInt(7, b.getNo());
			pstmt.setString(8, b.getPwd());
			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}

	public void updateHit(int no) {
		String sql = "UPDATE board SET hit=hit+1 WHERE no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}