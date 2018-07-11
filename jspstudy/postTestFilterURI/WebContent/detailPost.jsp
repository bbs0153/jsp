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

	<h2>�� ��</h2>
	<hr>
	�۹�ȣ : ${p.no }
	<br> ������ : ${p.title}
	<br> �ۼ��� : ${p.writer}
	<br> ����� : ${p.regdate}
	<br> ��ȸ�� : ${p.hit}
	<br> �۳��� :
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
			<a href="deleteComment.do?cno=${comments.cno }&no=${p.no}">����</a>
		</c:if>

		<hr>
	</c:forEach>
	<br>
	<br>
	<form action="insertComment.do" method="post">
		<input type="hidden" name="writer" value="${id}"> <input
			type="hidden" name="no" value="${p.no}">
		<textarea rows="3" cols="50" name="content"></textarea>
		<input type="submit" value="���">
	</form>

	<br>

	<a href="listPost.do">�� ���</a>
</body>
</html>










