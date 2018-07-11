package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.db.ConnectionProvider;
import com.vo.BoardVO;

import oracle.net.aso.e;

public class BoardDAO {

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

	public int updateBoard(BoardVO b) {

		int re = -1;
		String sql = "UPDATE board SET title=?,writer=?,content=? WHERE no=? AND pwd=? ";

		try {

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getContent());
			pstmt.setInt(4, b.getNo());
			pstmt.setString(5, b.getPwd());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	// 조회수를 증가하기 위한 메소드 정의
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

	public BoardVO detailBoard(int no, boolean hitAdd) {

		if (hitAdd) {

			updateHit(no);
		}

		BoardVO b = new BoardVO();
		String sql = "SELECT * FROM board WHERE no=?";
		try {

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPwd(rs.getString(4));
				b.setRegdate(rs.getDate(5));
				b.setHit(rs.getInt(6));
				b.setContent(rs.getString(7));
			}

			ConnectionProvider.close(rs, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return b;

	}

	public ArrayList<BoardVO> listBorad() {

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "SELECT * FROM board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7)));
			}

			ConnectionProvider.close(rs, stmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return list;
	}

	public int insertBoard(BoardVO b) {

		int re = -1;

		String sql = "INSERT INTO board VALUES(?,?,?,?,sysdate,0,?)";

		try {

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 다음 글번호를 위한 메소드를 호출하자

			int no = getNextNo();

			pstmt.setInt(1, no);
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContent());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	private int getNextNo() {

		int no = 0;
		String sql = "SELECT nvl(max(no),0)+1 FROM board";
		// 게시판의 글번호중에 가장 큰 값에 +1
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
}
