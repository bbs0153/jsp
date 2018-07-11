<%@page import="com.vo.BoardVO"%>
<%@page import="com.dao.BoardDAO"%>
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

		BoardVO b = new BoardVO();
		b.setTitle(request.getParameter("title"));
		b.setWriter(request.getParameter("writer"));
		b.setContent(request.getParameter("content"));

		BoardDAO dao = new BoardDAO();
		int re = dao.insertBoard(b);

		if (re > 0) {

			out.print("<font color='blue'>성공</font>");

		} else {

			out.print("<font color='red'>실패</font>");
		}
	%>

</body>
</html>