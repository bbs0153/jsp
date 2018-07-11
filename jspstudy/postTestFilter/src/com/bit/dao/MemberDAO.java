package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.db.ConnectionProvider;

public class MemberDAO {

	public boolean isMember(String id, String pwd) {

		boolean re = false;
		String sql = "SELECT * FROM member WHERE id=? AND pwd=?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				re = true;
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;
	}

}
