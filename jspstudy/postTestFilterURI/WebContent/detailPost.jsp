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

	<h2>글 상세</h2>
	<hr>
	글번호 : ${p.no }
	<br> 글제목 : ${p.title}
	<br> 작성자 : ${p.writer}
	<br> 등록일 : ${p.regdate}
	<br> 조회수 : ${p.hit}
	<br> 글내용 :
	<br>
	<textarea rows="10" cols="60">${p.content }</textarea>
	<br>
	<br>
	<br>

	<c:forEach var="comments" items="${comment_list}">
	${comments.writer}<br>
	${comments.content}<br>
	${comments.regdate}<br>

		<c:if test="${id==comments.writer}">
			<a href="deleteComment.do?cno=${comments.cno }&no=${p.no}">삭제</a>
		</c:if>

		<hr>
	</c:forEach>
	<br>
	<br>
	<form action="insertComment.do" method="post">
		<input type="hidden" name="writer" value="${id}"> <input
			type="hidden" name="no" value="${p.no}">
		<textarea rows="3" cols="50" name="content"></textarea>
		<input type="submit" value="등록">
	</form>

	<br>

	<a href="listPost.do">글 목록</a>
</body>
</html>










