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
<%
	
	String id = request.getParameter("id");
	
	MemberDAO dao = new MemberDAO();
	MemberVO m = dao.selectMember(id);
	
%>
<h2>회원수정</h2>
	<hr>
	<form action="updateMemberOk.jsp" method="post">
		아이디 : <input type="text" name="id" value="<%=m.getId()%>"><br>
		비밀번호 : <input type="password" name="pwd" value="<%=m.getPwd()%>"><br>
		이름 : <input type="text" name="name" value="<%=m.getName()%>"><br>
		주소 : <input type="text" name="addr" value="<%=m.getAddr()%>"><br>
		이메일 : <input type="email" name="email" value="<%=m.getEmail()%>"><br>
		나이 : <input type="number" name="age" value="<%=m.getAge()%>"><br>
		취미 : 
		<input type="checkbox" name="hobby" value="마라톤">마라톤
		<input type="checkbox" name="hobby" value="수영">수영
		<input type="checkbox" name="hobby" value="크로스핏">크로스핏
		<input type="checkbox" name="hobby" value="클라이밍">클라이밍
		<input type="checkbox" name="hobby" value="재즈댄스">재즈댄스
		<input type="checkbox" name="hobby" value="플라잉요가">플라잉요가
		
		<br>
		전화번호 : <input type="tel" name="tel" value="<%=m.getTel()%>"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>



</body>
</html>