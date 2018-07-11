<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>글 작성하기</h2>
<hr>
<form action="insertBoardOK.jsp" method="post" enctype="multipart/form-data">


제목:<input type="text" name="title"><br>
작성자:<input type="text" name="writer"><br>
비밀번호:<input type="password" name="pwd"><br>
내용:<br>
<textarea name="content" rows="10" cols="60"></textarea><br>
파일명:<input type="file" name="fname"><br>

<input type="submit" value="등록">
<input type="reset" value="취소">
</form>

</body>
</html>