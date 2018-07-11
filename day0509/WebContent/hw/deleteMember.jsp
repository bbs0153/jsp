<%@page import="com.db.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">회원삭제</h1>
<hr>
	<%
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		int re = dao.deletMemeber(id);

		if (re > 0) {
			%>
			<font color="blue">삭제성공</font>
			<%
		} else {
			%>
			<font color="blue">삭제성공</font>
			<%
		}
	%>
	<a href="listMember.jsp">회원목록</a>
</body>
</html>