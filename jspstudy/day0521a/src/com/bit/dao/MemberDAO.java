package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;

public class MemberDAO {

	public Boolean isMember(String id, String pwd) {

		boolean b = false;

		String sql = "SELECT name FROM member WHERE id=? AND pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnetion();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				b = true;

			}

			ConnectionProvider.close(rs, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return b;
	}
}
