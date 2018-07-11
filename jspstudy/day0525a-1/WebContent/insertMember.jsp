<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>회원등록</h2>
<hr>
<form action="insertMemberOk.do" method="post" enctype="multipart/form-data">
아이디 : <input type="text" name="id"><br>
암호 : <input type="password" name="pwd"><br>
이름 : <input type="text" name="name"><br>
주소 : <input type="text" name="addr"><br>
이메일 : <input type="email" name="email"><br>
나이 : <input type="number" name="age"><br>
취미 : <input type="text" name="hobby"><br>
전화 : <input type="text" name="tel"><br>
파일 : <input type="file" name="fname"><br>
<input type="submit" value="등록">
</form>
</body>
</html>