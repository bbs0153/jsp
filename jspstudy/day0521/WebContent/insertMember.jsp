<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원등록</h2>
	<hr>
	
	<form action="insertMemberOK.jsp" method ="post">
	아이디 : <input type="text" name="id"><br>
	암호 : <input type="password" name="pwd"><br>
	이름 : <input type="text" name="name"><br>
	주소 : <input type="text" name="addr"><br>
	이메일: <input type="email" name="email"><br>
	나이 : <input type="number" name="age"><br>
	취미 : <input type="text" name="hobby"><br>
	전화 : <input type="tel" name="tel"><br>
	파일 : <input type="text" name="fname"><br>
	
	<input type="submit" value="등록">
	
	</form> 
</body>
</html>