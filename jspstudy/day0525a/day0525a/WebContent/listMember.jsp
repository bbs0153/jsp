<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>ȸ�����</h2>
	<hr>
	<table border="1" width="60%">
		<tr>
			<td>���̵�</td>
			<td>�̸�</td>
			<td>����</td>
			<td>���</td>
		</tr>

		<c:forEach var="m" items="${list}">
			<tr>
				<td>${m.id}</td>
				<td><a href="detailMember.do?id=${m.id}">${m.name}</a></td>
				<td>${m.age}</td>
				<td>${m.hobby}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="insertMember.do">ȸ�� ���</a>
</body>
</html>