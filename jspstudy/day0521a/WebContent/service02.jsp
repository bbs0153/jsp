<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<%
		if (session.getAttribute("id") == null) {

			response.sendRedirect("login.jsp");

		}
	%>
<h2>서비스2 입니다.</h2>
<hr>
</body>
</html>