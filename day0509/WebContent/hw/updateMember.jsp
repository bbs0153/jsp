<%@page import="com.vo.MemberVO"%>
<%@page import="com.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">회원수정</h1>
<hr>
<%
String id = request.getParameter("id");

MemberDAO dao = new MemberDAO();
MemberVO mv = dao.selectMember(id);

String pwd = mv.getPwd();
String name = mv.getName();
String addr = mv.getAddr();
String email = mv.getEmail();
int age = mv.getAge();
String tel = mv.getTel();

%>

<form action="updateMemberOK.jsp" method="post">
	<table>
	<tr><td>아이디</td><td><input type="text" name="id" value="<%=id%>"></td></tr>
	<tr><td>비밀번호</td><td><input type="text" name="pwd" value="<%=pwd%>"></td></tr>
	<tr><td>이름</td><td><input type="text" name="name" value="<%=name%>"></td></tr>
	<tr><td>주소</td><td><input type="text" name="addr" value="<%=addr%>"></td></tr>
	<tr><td>이메일</td><td><input type="text" name="email" value="<%=email%>"></td></tr>
	<tr><td>나이</td><td><input type="number" name="age" value="<%=age%>"></td></tr>
	<tr><td>취미</td><td>	
	<input type="checkbox" name="hobby" value="마라톤">마라톤 
	<input type="checkbox" name="hobby" value="수영">수영
	<input type="checkbox" name="hobby" value="크로스핏">크로스핏 
	<input type="checkbox" name="hobby" value="클라이밍">클라이밍
	<input type="checkbox" name="hobby" value="재즈댄스">재즈댄스
	<input type="checkbox" name="hobby" value="플라잉요가">플라잉요가</td></tr>
	<tr><td>전화번호</td><td><input type="text" name="tel" value="<%=tel%>"></td></tr>
	</table>
	<input type="submit" value="등록">

</body>
</html>