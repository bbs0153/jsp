<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateMemberOk.do" method="post" enctype="multipart/form-data">
아이디 : ${m.id} <input type="hidden" name="id" value="${m.id}"><br>
암호 : <input type="password" name="pwd"><br>
이름 : <input type="text" name="name" value="${m.name}"><br>
주소 : <input type="text" name="addr" value="${m.addr}"><br>
이메일 : <input type="email" name="email" value="${m.email}"><br>
나이 : <input type="number" name="age" value="${m.age}"><br>
취미 : <input type="text" name="hobby" value="${m.hobby}"><br>
전화 : <input type="text" name="tel" value="${m.tel}"><br>
파일 : <input type="file" name="fname" value="${m.fname}"><br>
<input type="submit" value="수정">
<input type="reset" value="취소">

</form>
</body>
</html>