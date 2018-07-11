package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.GoodsVO;

public class GoodsDAO {
	
public int deleteGoods(int no) {
		
		int re = -1;
		String sql = "delete goods WHERE no=?";
		
		try {
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		return re;
		
		
		
	}

	public int updateGoods(GoodsVO g) {

		int re = -1;
		String sql = "UPDATE goods SET item=?,price=?,qty=?,fname=? WHERE no=?";

		try {

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getItem());
			pstmt.setInt(2, g.getPrice());
			pstmt.setInt(3, g.getQty());
			pstmt.setString(4, g.getFname());
			pstmt.setInt(5, g.getNo());

			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, conn, pstmt);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	
	public int insertGoods(GoodsVO g) {
		int re = -1;
		//쿼리문이 성공한 개수를 반환
		String sql = "INSERT INTO goods VALUES(?,?,?,?,?)";
		//goods에 상품을 추가하는 INSERT문
		try {
			Connection conn = ConnectionProvider.getConnection();
			//ConnectionProvider 클래스의 static메소드인 getConnection을 통해서 dbServer에 연결한다.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//쿼리문에 넣을 값이 일정하지 않을 때 쿼리문에 ?로 대신하고 PrepareStatement를 이용하여 값을 설정해준다.
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getItem());
			pstmt.setInt(3, g.getPrice());
			pstmt.setInt(4, g.getQty());
			pstmt.setString(5, g.getFname());
			//?에 값을 설정해줌
			re = pstmt.executeUpdate();
			//쿼리문 실행
			ConnectionProvider.close(null, conn, pstmt);
			//ConnectionProvider의 close메소드를 이용하여 닫아줌
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}

	public GoodsVO getGoods(int no) {
		GoodsVO g = new GoodsVO();
		String sql = "SELECT * FROM goods WHERE no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				g = new GoodsVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				// g.setNo(rs.getInt(1));
				// g.setItem((rs.getString(2)));
				// g.setPrice(rs.getInt(3));
				// g.setQty(rs.getInt(4));
				// g.setFname(rs.getString(5));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return g;
	}

	public ArrayList<GoodsVO> listGoods() {

		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "SELECT * from goods";

		try {

			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				GoodsVO g = new GoodsVO();

				g.setNo(rs.getInt(1));
				g.setItem((rs.getString(2)));
				g.setPrice(rs.getInt(3));
				g.setQty(rs.getInt(4));
				g.setFname(rs.getString(5));

				list.add(g);
			}
			ConnectionProvider.close(rs, conn, stmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return list;
	}

}
