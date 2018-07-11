package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.MemberVO;

public class MemberDAO {
	
	public int insertMember(MemberVO m) {
		
		int re = -1;
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?)"; 
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getAddr());
			pstmt.setString(5, m.getEmail());
			pstmt.setInt(6, m.getAge());
			pstmt.setString(7, m.getHobby());
			pstmt.setString(8, m.getTel());
			pstmt.setString(9, m.getFname());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
			
		}catch (Exception e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
		}
		
		return re;
		
	}

	public MemberVO getMember(String id) {
		
		MemberVO m = new MemberVO();
		String sql = "SELECT * FROM member WHERE id=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				m.setId(rs.getString(1));
				m.setPwd(rs.getString(2));
				m.setName(rs.getString(3));
				m.setAddr(rs.getString(4));
				m.setEmail(rs.getString(5));
				m.setAge(rs.getInt(6));
				m.setHobby(rs.getString(7));
				m.setTel(rs.getString(8));
				m.setFname(rs.getString(9));
			}
			
			ConnectionProvider.close(rs, pstmt, conn);
			
		}catch (Exception e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
		}
		
		
		
		return m;
		
		
	}

	public ArrayList<MemberVO> listMember() {

		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM member";

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}

			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
