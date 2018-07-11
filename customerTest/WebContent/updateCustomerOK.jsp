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

	<%
	request.setCharacterEncoding("EUC-KR");
	String sql = "UPDATE customer SET name = ?, address = ?, phone = ? WHERE custid = ?";
	
	try{
		int custid = Integer.parseInt(request.getParameter("custid"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","madang","madang");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, address);
		pstmt.setString(3, phone);
		pstmt.setInt(4, custid);
		
		int re = pstmt.executeUpdate();
	
		if(re>0){
			%>
			<font color="blue">고객정보 수정 성공!!!!</font>
			<%
		}else{
			
			%>
			<font color="red">고객정보 수정 실패!!!!</font>
			<%
		}
		
		pstmt.close();
		conn.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
		
		
	





%>
</body>
</html>