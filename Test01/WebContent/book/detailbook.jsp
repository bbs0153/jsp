<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>도서 상세</h2>
	<hr>

	<%
		int bid = Integer.parseInt(request.getParameter("bid"));

		String sql = "SELECT * FROM book WHERE bookid = ?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang",
					"madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				%>
				도서번호 :<%=rs.getInt(1)%> <br>
				도서명 :<%=rs.getString(2)%><br>
				출판사 :<%=rs.getString(3)%><br>
				가격 :<%=rs.getInt(4)%>
				<%
		}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	%>
	
	
	<hr>
	<a href="listBook.jsp">도서목록</a>
	
</body>
</html>