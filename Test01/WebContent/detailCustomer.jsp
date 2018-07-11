<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>고객상세정보</h1>
<%

	int cid = Integer.parseInt(request.getParameter("cid"));
	String sql = "SELECT * FROM customer WHERE custid = ?"; 
	try{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:XE","madang","madang");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cid);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			%>
			고객번호 : <%= rs.getInt(1) %><br>
			고객명: <%= rs.getString(2) %><br>
			주소 : <%= rs.getString(3) %><br>
			핸드폰번호 : <%= rs.getString(4) %>
			<%
			
			rs.close();
			pstmt.close();
			conn.close();
		}
	
	
	}catch(Exception e){
	
		System.out.println(e.getMessage());
	}
  %>
  
  <a href = "customerList.jsp">고객</a>

</body>
</html>