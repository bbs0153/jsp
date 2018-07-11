<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>${title}</h2>
	<hr>
	<table border="1" width="60%">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>등록일</td>
		</tr>
		
		<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.no}</td>
			<td><a href="detailBoard.do?no=${b.no}">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.hit}</td>
			<td>${b.regdate}</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	${pageStr}
</body>
</html>