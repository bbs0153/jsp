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
<h2>수정</h2>
<hr>
<%
int no = Integer.parseInt(request.getParameter("no"));
String pwd = request.getParameter("pwd");
BoardDAO dao = new BoardDAO();
BoardVO b = dao.detailBoard(no, false);
%>
<form action="updateBoardOK.jsp" method="post" enctype="multipart/form-data">

<input type="hidden" name="no" value="<%=no%>">
제목:<input type="text" name="title" value="<%=b.getTitle() %>"><br>
작성자:<input type="text" name="writer" value="<%=b.getWriter() %>"><br>
암호:<input type="password" name="pwd"><br>
내용:<br>
<textarea name="content" rows="10" cols="60"><%=b.getContent() %></textarea><br>
첨부파일:<%=b.getFname() %>(<%=b.getFsize() %>)<br>
<input type="file" name="fname"><br>

<input type="submit" value="수정">
<input type="reset" value="취소">
</form>


</body>
</html>