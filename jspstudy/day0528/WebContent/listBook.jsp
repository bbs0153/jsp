<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="60%">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>가격</td>
		</tr>

		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.bookid}</td>
				<td><a href="detailBook.do?bookid=${b.bookid}">${b.bookname}</td>
				<td>${b.price }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertBook.do">책 추가</a>

</body>
</html>