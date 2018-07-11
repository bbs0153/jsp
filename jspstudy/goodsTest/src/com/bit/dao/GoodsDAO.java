package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.GoodsVO;

public class GoodsDAO {

	public static int pageSIZE = 3;
	// 한 화면에 보여줄 상품의 수
	public static int totalRecord = 0;
	// 전체 상품의 수를 저장할 변수
	public static int totalPage = 1;
	// 전체 페이지 수를 저장할 변수
	public static int pageGROUP = 5;
	// 한 화면에 보여줄 페이지의 수
	public static int pageNUM = 1;
	// 현재 페이지를 저장할 편수

	public int deleteGoods(int no) {

		int re = -1;
		String sql = "DELETE goods WHERE no=?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
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

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	public int insertGoods(GoodsVO g) {

		int re = -1;
		String sql = "INSERT INTO goods VALUES(?,?,?,?,?)";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getItem());
			pstmt.setInt(3, g.getPrice());
			pstmt.setInt(4, g.getQty());
			pstmt.setString(5, g.getFname());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
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
				g.setNo(rs.getInt(1));
				g.setItem(rs.getString(2));
				g.setPrice(rs.getInt(3));
				g.setQty(rs.getInt(4));
				g.setFname(rs.getString(5));
			}

			ConnectionProvider.close(rs, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return g;
	}

	public ArrayList<GoodsVO> listGoods(int pageNUM) {

		this.pageNUM = pageNUM;

		totalRecord = getTotalCount();
		totalPage = (int) Math.ceil(totalRecord / (double) pageSIZE);

		// totalPage = totalRecord / pageSIZE;
		// if (totalRecord % pageSIZE != 0) {
		// totalPage++;
		// }

		int start;// 현재 페이지에 보여줄 시작 위치
		int end; // 현재 페이지에 보여줄 마지막 위치

		// 한 화면에 5개의 상품을 보여주고자 한다 == pageSIZE
		// 만약에 현재페이지가 1페이지라면 ==> pageNUM
		// start=1, end=5
		// 만약에 현제페이지가 2페이지라면
		// start=6, end=10
		start = (pageNUM - 1) * pageSIZE + 1;
		end = start + pageSIZE - 1;

		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "SELECT no,item,price,qty,fname FROM " + "(SELECT rownum r,no,item,price,qty,fname FROM "
				+ "(SELECT * FROM goods ORDER BY no)) a " + "WHERE a.r between ? and ?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(new GoodsVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));

			}

			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}

	public int getTotalCount() {

		int n = 0;
		String sql = "SELECT COUNT(*) FROM goods";

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return n;
	}

	// page처리를 위한 문자열을 반환하는 메소드 정의
	public String getPageStr() {

		int startPage = 1;
		int endPage = 1;
		// 한 화면에 보여줄 페이지의 수를 5개씩 보여주려 하고
		// 만약에 현재페이지가 1,2,3,4,5 ==> 시작페이지 1
		// 만약에 현재페이지가 6,7,8,9,10 ==> 시작페이지 6
		// 만약에 현재페이지가 11,12,13,14,15 ==> 시작페이지 11

		startPage = (pageNUM + pageGROUP - 1) / pageGROUP * pageGROUP - (pageGROUP - 1);
		// (3 + 5 -1) / 5 * 5 - (5 -1)
		// 현재페이지가 3일때 startPage는 1이 나와야 함

		endPage = startPage + pageGROUP - 1;
	

		String str = "";

		if (startPage > 1) {
			str = str + "<a href='listGoods.do?pageNUM=" + (startPage - 1) + "'>[이전]</a>";
		}
		// 앞쪽으로 더 보여줄 페이지가 있다면 [이전]을 표시한다.
		// [이전]을 누르면 startPage-1을 보여주도록 한다.
		for (int i = startPage; i <= endPage; i++) {
			str = str + "<a href='listGoods.do?pageNUM=" + i + "'>" + i + "</a> ";
		}
		// 현재페이지에 보여줄 시작페이지 부터 마지막 페이지까지 목록을 만든다.

		if (endPage < totalPage) {
			str = str + "<a href='listGoods.do?pageNUM=" + (endPage + 1) + "'>[다음]</a>";
		}
		// 더 보여줄 페이지가 있다면 [다음]을 표시한다.
		// 다음을 누르면 endPage+1을 보여주도록 한다.

		return str;
	}
}
