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
		if (session.getAttribute("id") == null) {

			response.sendRedirect("login.jsp");
		}
	%>
	<h2>비트 렌터카</h2>
	<hr>
	<%
		String id = (String) session.getAttribute("id");
		String pwd = (String) session.getAttribute("pwd");
	%>
	<a href="service01.jsp">서비스1</a><br>
	<a href="service02.jsp">서비스2</a><br>
	<a href="service03.jsp">서비스3</a><br>
</body>
</html>