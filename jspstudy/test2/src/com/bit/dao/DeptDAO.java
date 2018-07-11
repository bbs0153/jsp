package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bit.db.ConnectionProvider;
import com.bit.vo.DeptVO;

public class DeptDAO {
	
	public int insertDept(DeptVO d) {
		
		int re = -1;
		String sql = "INSERT INTO dept VALUES(?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;
		
	}

}
