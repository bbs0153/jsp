package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.EmpVO;

public class EmpDAO {
	
	public int updateEmp(EmpVO e) {
		int re=-1;
		String sql="UPDATE emp SET ename=?,sal=?,comm=?,hiredate=?,jumin=?,dno=?,position=?,addr=?,mgr=?,email=? WHERE eno=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getEname());
			pstmt.setInt(2, e.getSal());
			pstmt.setInt(3, e.getComm());
			pstmt.setString(4, e.getHiredate());
			pstmt.setString(5, e.getJumin());
			pstmt.setInt(6, e.getDno());
			pstmt.setString(7, e.getPosition());
			pstmt.setString(8, e.getAddr());
			pstmt.setInt(9, e.getMgr());
			pstmt.setString(10, e.getEmail());
			pstmt.setInt(11, e.getEno());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		
		return re;
	}
	
	public ArrayList<Integer> listMgr(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql="SELECT eno FROM emp WHERE position NOT IN('사원')";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
			
			ConnectionProvider.close(rs, stmt, conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public ArrayList<String> listPosition(){
		ArrayList<String> list = new ArrayList<String>();
		String sql="SELECT DISTINCT position FROM emp WHERE position IS NOT NULL";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
			ConnectionProvider.close(rs, stmt, conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	//모든 부서번호 목록을 반환하는 메소드를 정의
	public ArrayList<Integer> listDno(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql="SELECT dno FROM dept";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
			
			ConnectionProvider.close(rs, stmt, conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public int insertEmp(EmpVO e) {
		int re=-1;
		
		String sql="INSERT INTO emp VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, e.getEno());
			pstmt.setString(2, e.getEname());
			pstmt.setInt(3, e.getSal());
			pstmt.setInt(4, e.getComm());
			pstmt.setString(5, e.getHiredate());
			pstmt.setString(6, e.getJumin());
			pstmt.setInt(7, e.getDno());
			pstmt.setString(8, e.getPosition());
			pstmt.setString(9, e.getAddr());
			pstmt.setInt(10, e.getMgr());
			pstmt.setString(11, e.getEmail());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		
		return re;
	}
	
	public int deleteEmp(int eno) {
		int re = -1;
		String sql = "DELETE emp WHERE eno=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return re;
	}
	
	public EmpVO getEmp(int eno) {
		
		EmpVO e = null;
		String sql = "SELECT * FROM emp WHERE eno=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				e = new EmpVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDate(5) + "",
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getString(11));
			}
			
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return e;
	}
	
	public ArrayList<EmpVO> listEmp() {

		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		String sql = "SELECT * FROM emp";

		try {

			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				list.add(new EmpVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDate(5) + "",
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getString(11)));
			}

			ConnectionProvider.close(rs, stmt, conn);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return list;

	}

}
