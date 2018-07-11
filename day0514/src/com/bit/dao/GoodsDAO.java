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
		//�������� ������ ������ ��ȯ
		String sql = "INSERT INTO goods VALUES(?,?,?,?,?)";
		//goods�� ��ǰ�� �߰��ϴ� INSERT��
		try {
			Connection conn = ConnectionProvider.getConnection();
			//ConnectionProvider Ŭ������ static�޼ҵ��� getConnection�� ���ؼ� dbServer�� �����Ѵ�.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//�������� ���� ���� �������� ���� �� �������� ?�� ����ϰ� PrepareStatement�� �̿��Ͽ� ���� �������ش�.
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getItem());
			pstmt.setInt(3, g.getPrice());
			pstmt.setInt(4, g.getQty());
			pstmt.setString(5, g.getFname());
			//?�� ���� ��������
			re = pstmt.executeUpdate();
			//������ ����
			ConnectionProvider.close(null, conn, pstmt);
			//ConnectionProvider�� close�޼ҵ带 �̿��Ͽ� �ݾ���
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
