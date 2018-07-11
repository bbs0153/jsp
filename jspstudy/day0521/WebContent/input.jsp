<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>회원 정보</h2>
<hr>
<form action="result.jsp" method="post">
	이름 : <input type="text" name="name"><br>
	이름 : <input type="text" name="age"><br>
	<input type="submit" value="확인">
</form>
	<font color="red">Ps : 나이는 반드시 숫자로 입력하세요.</font>
</body>
</html>