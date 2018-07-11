package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BookVO;

public class BookDAO {

	public int deleteBook(int bookid) {

		int re = -1;
		String sql = "DELETE book WHERE bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;

	}

	public int updateBook(BookVO b) {

		int re = -1;
		String sql = "UPDATE book SET bookname=?,publisher=?,price=? WHERE bookid=?";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookname());
			pstmt.setString(2, b.getPublisher());
			pstmt.setInt(3, b.getPrice());
			pstmt.setInt(4, b.getBookid());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	public int insertBook(BookVO b) {

		int re = -1;
		String sql = "INSERT INTO book VALUES(?,?,?,?)";

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBookid());
			pstmt.setString(2, b.getBookname());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(null, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;

	}

	public BookVO getBook(int bookid) {

		BookVO b = null;
		String sql = "SELECT * FROM book WHERE bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				b = new BookVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}

			ConnectionProvider.close(rs, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return b;

	}

	public ArrayList<BookVO> listBook() {

		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "SELECT * FROM book";

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			ConnectionProvider.close(rs, stmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return list;

	}

}
