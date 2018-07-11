package com.bit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BoardVO;

public class BoardDAO {

	public static int pageSIZE = 3;
	// 한화면에 보여줄 레코드의 수
	public static int totalRecord = 0;
	// 전체 레코드의 수를 저장할 변수
	public static int totalPage = 1; 
	// 전체 페이지수를 저장할 변수
	public static int pageGROUP = 5;
	public static int pageNUM = 1;

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
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
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
			System.out.println(e.getMessage());
		}

		return re;
	}

	public int getNextNo() {

		int no = 0;
		String sql = "SELECT nvl(MAX(no),0)+1 FROM board";

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				no = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return no;
	}

	public int insertBoard(BoardVO b) {

		int no = getNextNo();
		int re = -1;
		String sql = "INSERT INTO board VALUES(?,?,?,?,sysdate,0,?,?,?,?)";

		try {

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

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	public BoardVO getBoard(int no, boolean f) {

		if (f) {

			updateHit(no);

		}

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
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return b;
	}

	public void updateHit(int no) {

		String sql = "UPDATE board SET hit=hit+1 WHERE no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeQuery();

			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<BoardVO> listBoard(int pageNUM) {
		
		this.pageNUM = pageNUM;
		
		totalRecord = getCount();
		totalPage = totalRecord / pageSIZE;
		if (totalRecord % pageSIZE != 0) {
			totalPage++;
		}

		// 매개변수로 전달받은 pageNUM에 보여줄 레코드를 10개만 반환하도록 해야 한다.
		// 현재페이지에 따른 시작레코드와 마지막레코드르 계산
		int start;
		int end;

		start = (pageNUM - 1) * pageSIZE + 1;
		end = start + pageSIZE - 1;

		if (end > totalRecord) {
			end = totalRecord;
		}

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "SELECT no, title,writer,pwd,regdate,hit,content,fname,fsize,ip " + "FROM "
				+ "(SELECT rownum r,no,title,writer,pwd,regdate,hit,content,fname,fsize,ip " + "FROM "
				+ "(SELECT * FROM board ORDER BY regdate desc)) a " + "WHERE a.r between ? AND ?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10)));
			}
			ConnectionProvider.close(rs, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return list;

	}

	public int getCount() {

		int count = 0;
		String sql = "SELECT COUNT(*) FROM board";

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				count = rs.getInt(1);
			}

			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return count;

	}

	public String getPageStr() {

		int startPage = 1;
		int endPage = 1;

		startPage = (pageNUM + pageGROUP - 1) / pageGROUP * pageGROUP - (pageGROUP - 1);
		endPage = startPage + pageGROUP - 1;

		String str = "";

		if (startPage > 1) {
			str = str + "<a href='listBoard.do?pageNUM=" + (startPage - 1) + "'>[이전]</a>";
		}
		for (int i = startPage; i <= endPage; i++) {
			str = str + "<a href='listBoard.do?pageNUM=" + i + "'>" + i + "</a>";
		}
		if (endPage < totalPage) {
			str = str + "<a href='listBoard.do?pageNUM=" + (endPage + 1) + "'>[다음]</a>";
		}

		return str;

	}

}
