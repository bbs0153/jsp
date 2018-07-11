<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">${title }</h2>
<hr>
<form action="insertBoardOk.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="${no}">
글제목:<input type="text" name="title"><br>
작성자:<input type="text" name="writer"><br>
글암호:<input type="password" name="pwd"><br>
글내용:<br>
<textarea rows="10" cols="60" name="content"></textarea><br>
파일:<input type="file" name="fname"><br>
<input type="submit" value="등록">
<input type="reset" value="취소">

</form>

</body>
</html>