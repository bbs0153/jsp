<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 	<% 
 	
 	// 사용자가 요청한 문자는 한글입니다. 라고 설정
 	
		request.setCharacterEncoding("EUC-KR");
 		String sql = "UPDATE book SET bookname=?,publisher=?,price=? WHERE bookid=?";
 	
 		try{
 			
 			int bookid = Integer.parseInt(request.getParameter("bookid"));
 			String bookname = request.getParameter("bookname");
 			String publisher = request.getParameter("publisher");
 			int price = Integer.parseInt(request.getParameter("price"));
 			
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang", "madang");
 			PreparedStatement pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, bookname);
 			pstmt.setString(2, publisher);
 			pstmt.setInt(3, price);
 			pstmt.setInt(4, bookid);
 			
 			
 			int re = pstmt.executeUpdate();
 			
 			if(re > 0){
 				%>
 				<font color="blue">도서수정 성공!!!</font>
 				<%
 			}else{
 				%>
 				<font color="red">도서수정 실패!!!</font>
 				<%
 			}
 			
 			pstmt.close();
 			conn.close();
 		}catch(Exception e){
 			
 			System.out.println(e.getMessage());
 		}
 	%>
 	<ht>
 	<a href="listBook.jsp">도서목록</a>
</body>
</html>