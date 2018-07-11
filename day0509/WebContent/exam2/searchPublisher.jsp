<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
<table border="1">
	<%
		request.setCharacterEncoding("EUC-KR");
		String publisher = request.getParameter("publisher");
		String sql = "SELECT * FROM book WHERE publisher=?";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","madang","madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				%>
				<tr>
				<td>도서번호:<%=rs.getInt(1) %></td>
				<td>도서명:<%=rs.getString(2) %></td>
				<td>출판사:<%=rs.getString(3) %></td>
				<td>가격:<%=rs.getInt(4) %></td>
				</tr>
				<%
				
			}
		
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}


	%>



</table>
</body>
</html>