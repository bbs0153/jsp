<%@page import="com.bit.vo.MemberVO"%>
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
	MemberVO mb = new MemberVO();
	mb.setName("변성인짱");
	mb.setAge(50);
	mb.setHobby("자전거");
	out.print("이름 :"+mb.getName()+"<br>");
	out.print("나이 :"+mb.getAge()+"<br>");
	out.print("취미 :"+mb.getHobby()+"<br>");
%>
	이름 : <%= mb.getName() %><br>
	나이 : <%= mb.getAge() %><br>
	취미 : <%= mb.getHobby() %>
	<hr>
</body>
</html>