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
	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();
		int re = dao.deleteMember(id, pwd);

		if (re > 0) {

			response.sendRedirect("listMember.jsp");

		} else {

			response.sendRedirect("deleteMember.jsp?id="+id);
		}
	%>
</body>
</html>