package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.MemberVO;

public class MemberDAO {

	public int deleteMember(String id, String pwd) {

		int re = -1;
		String sql = "DELETE member WHERE id=?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	public int updateMember(MemberVO m) {

		int re = -1;
		String sql = "UPDATE member SET name=?,addr=?,email=?,age=?,hobby=?,tel=?,fname=? WHERE id=? AND pwd=?";

		try {

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getAddr());
			pstmt.setString(3, m.getEmail());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getHobby());
			pstmt.setString(6, m.getTel());
			pstmt.setString(7, m.getFname());
			pstmt.setString(8, m.getId());
			pstmt.setString(9, m.getPwd());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	public MemberVO detailMember(String id) {

		MemberVO m = new MemberVO();
		String sql = "SELECT * FROM member WHERE id=?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				m = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}

			ConnectionProvider.close(rs, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return m;

	}

	public ArrayList<MemberVO> getMember() {

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
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return list;

	}

	public int insertMember(MemberVO v) {

		int re = -1;
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?)";

		try {

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setString(4, v.getAddr());
			pstmt.setString(5, v.getEmail());
			pstmt.setInt(6, v.getAge());
			pstmt.setString(7, v.getHobby());
			pstmt.setString(8, v.getTel());
			pstmt.setString(9, v.getFname());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

}
