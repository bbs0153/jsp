<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>${title}</h2>
<hr>
<form action="insertBoardOK.do" method ="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value=${no}>
	제목 : <input type="text" name="title"><br>
	작성자 : <input type="text" name="writer"><br>
	비밀번호 : <input type="password" name="pwd"><br>
	내용 : <br><textarea rows="10" cols="60" name="content"></textarea><br>
	파일 : <input type="file" name="fname"><br>
	
	<input type="submit" value="등록">
	</form> 
</body>
</html>