<%@page import="java.sql.ResultSet"%>
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

<form action="searchDloc.jsp" method="post">
<%

String sql = "SELECT DISTINCT dloc FROM dept";

try{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","madang","madang");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	while(rs.next()){
		%>
			<input type="radio" name="dloc" value="<%=rs.getString(1) %>"><%=rs.getString(1) %>
		<% 
	}
	
	rs.close();
	stmt.close();
	conn.close();
	
}catch(Exception e){
	
	System.out.println(e.getMessage());
}
%>

<input type="submit" value="�˻�">
</form>
</body>
</html>