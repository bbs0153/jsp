<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="60%">
<tr>
<td>
이미지: <img src="upload/${m.fname }">
</td>
<td>
아이디:${m.id}<br>
비밀번호:${m.pwd}<br>
이름:${m.name}<br>
주소:${m.addr}<br>
이메일:${m.email}<br>
나이:${m.age}<br>
취미:${m.hobby}<br>
전화번호:${m.tel}<br>
</td>
</tr>
</table>
<a href="updateMember.do">회원수정</a>
<a href="deleteMember.do">회원삭제</a>
</body>
</html>