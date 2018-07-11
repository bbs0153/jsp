package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BoardVO;

public class BoardDAO {

	public ArrayList<BoardVO> listBaord() {

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "SELECT * FROM board ORDER BY b_ref desc, b_step";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getInt(13)));

			}

			ConnectionProvider.close(rs, stmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}

	// 게시물번호를 매개변수로 전달받아 해당게시물을 반환하는 메소드
	public BoardVO getBoard(int no) {

		String sql = "SELECT * FROM board WHERE no=?";
		BoardVO b = null;
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				b = new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getInt(13));
			}

			ConnectionProvider.close(rs, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return b;
	}

	// 새로운 게시물 번호를 반환하는 메소드
	public int getNextNo() {

		int no = 0;
		String sql = "SELECT nvl(max(no),0)+1 FROM board";
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

	// 이미 달려 있는 답글들의 b_step을 증가하는 메소드
	public void updateStep(int b_ref, int b_step) {

		String sql = "UPDATE board SET b_step=b_step+1 WHERE b_ref=? AND b_step>?";
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

	// 새글등록, 답글등록
	// 구분?? ==> b.getNO() 0이면 새글 0이 아니면 답글
	public int insertBoard(BoardVO b) {

		int re = -1;
		try {

			int no = getNextNo();
			int b_ref = no;
			int b_level = 0;
			int b_step = 0;

			// 만약에 답글 이라면
			if (b.getNo() != 0) {
				// 부모글의 b_ref, b_level, b_step을 갖고 온다
				b_ref = getBoard(b.getNo()).getB_ref();
				b_level = getBoard(b.getNo()).getB_level();
				b_step = getBoard(b.getNo()).getB_step();
				// 이미 달려 있는 답글들의 b_step을 증가시키기 위한 메소드을 호출
				updateStep(b_ref, b_step);
				// b_level과 b_step을 1씩 증가한다.
				b_level++;
				b_step++;
			}
			String sql = "INSERT INTO board VALUES(?,?,?,?,sysdate,0,?,?,?,?,?,?,?)";
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
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}

}
