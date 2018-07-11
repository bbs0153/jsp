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
<c:if test="${empty id}">
	<jsp:forward page="login.do"/>
</c:if>

	<h2>글 등록</h2>
	<form action="insertPostOk.do" method="post">		
		글제목 : <input type="text" name="title"><br>
		작성자 : <input type="text" name="writer" value="${id }"><br>
		글암호 : <input type="password" name="pwd"><br>
		글내용 : <br>
		<textarea rows="10" cols="60" name="content"></textarea><br>		
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>





