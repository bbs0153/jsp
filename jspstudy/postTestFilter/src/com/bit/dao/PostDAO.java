package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.PostVO;

public class PostDAO {
	public int insertPost(PostVO p) {
		int re = -1;
		String sql = "insert into post values(seq_post.nextval,?,?,?,sysdate,0,?)";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getTitle());
			pstmt.setString(2, p.getWriter());
			pstmt.setString(3, p.getPwd());
			pstmt.setString(4, p.getContent());

			re = pstmt.executeUpdate();
			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;
	}

	public ArrayList<PostVO> listPost() {
		ArrayList<PostVO> list = new ArrayList<PostVO>();
		String sql = "select * from post order by regdate desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new PostVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7)));
			}
			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}

	public PostVO getPost(int no) {
		PostVO p = null;
		String sql = "select * from post where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p = new PostVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7));
			}
			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return p;
	}
}
