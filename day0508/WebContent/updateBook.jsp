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
	<h2>��������</h2>
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
	
	<!-- method(���۹��) get: �Ķ���Ͱ� url�� ����� post: �Ķ���Ͱ� url�� ������ �ȵ�(�Ϲ������� ���� ��) ���ȼ���  get���� ���� -->
	<form action="updateBookOK.jsp" method="post"> 
	<table>
	<tr><td>������ȣ:</td><td><input type="text" name="bookid" value="<%=bookid %>"></td></tr>
	<tr><td>������:</td><td><input type="text" name="bookname" value="<%=bookname %>"></td></tr>
	<tr><td>���ǻ�:</td><td><input type="text" name="publisher" value="<%=publisher %>"></td></tr>
	<tr><td>����:</td><td><input type="text" name="price" value="<%=price %>"></td></tr>
	</table>
	
	<input type="submit" value ="���">
	</form>
	


</body>
</html>