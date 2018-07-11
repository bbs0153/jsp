package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.CommentsVO;
import com.bit.vo.PostVO;

public class CommentsDAO {

	public int deleteCommente(int cno) {

		int re = -1;
		String sql = "delete comments WHERE cno=?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	public ArrayList<CommentsVO> listComment(int no) {

		ArrayList<CommentsVO> list = new ArrayList<CommentsVO>();
		String sql = "select * from comments WHERE no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new CommentsVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5)));
			}
			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;

	}

	public int insertComments(CommentsVO c) {

		int re = -1;
		String sql = "insert into comments values(seq_comments.nextval,?,?,?,sysdate)";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getWriter());
			pstmt.setString(2, c.getContent());
			pstmt.setInt(3, c.getNo());

			re = pstmt.executeUpdate();
			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
