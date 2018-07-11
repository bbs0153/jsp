<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<c:if test="${empty id}">
	<jsp:forward page="login.do"/>
</c:if><body>

	<h2>�� ���</h2>
	<hr>
	<c:if test="${f==true}">
		<a href="insertPost.do">�۾���</a>
	</c:if>
	<table border="1" width="80%">
		<tr>
			<td>�۹�ȣ</td>
			<td>������</td>
			<td>�ۼ���</td>
			<td>�����</td>
		</tr>

		<c:forEach var="p" items="${list }">
			<tr>
				<td>${p.no }</td>
				<c:if test="${f==true}">
					<td><a href="detailPost.do?no=${p.no }">${p.title }</a></td>
				</c:if>
				<c:if test="${f!=true}">
				<td>${p.title}</td>
				</c:if>
				<td>${p.writer }</td>
				<td>${p.regdate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>