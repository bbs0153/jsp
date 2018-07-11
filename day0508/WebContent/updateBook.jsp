<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>도서수정</h2>
	<hr>
	<%
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	String sql = "SELECT * FROM book WHERE bookid=?";
	
	String bookname="";
	String publisher="";
	int price = 0;
	
	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang", "madang");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bookid);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			bookname=rs.getString(2);
			publisher=rs.getString(3);
			price=rs.getInt(4);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
	}catch(Exception e){
		
		System.out.println(e.getMessage());
	}
	
	%>
	
	<!-- method(전송방식) get: 파라미터가 url에 노출됨 post: 파라미터가 url에 노출이 안됨(일반적으로 많이 씀) 보안성이  get보다 높음 -->
	<form action="updateBookOK.jsp" method="post"> 
	<table>
	<tr><td>도서번호:</td><td><input type="text" name="bookid" value="<%=bookid %>"></td></tr>
	<tr><td>도서명:</td><td><input type="text" name="bookname" value="<%=bookname %>"></td></tr>
	<tr><td>출판사:</td><td><input type="text" name="publisher" value="<%=publisher %>"></td></tr>
	<tr><td>가격:</td><td><input type="text" name="price" value="<%=price %>"></td></tr>
	</table>
	
	<input type="submit" value ="등록">
	</form>
	


</body>
</html>