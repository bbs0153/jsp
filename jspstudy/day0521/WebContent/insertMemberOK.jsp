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
		request.setCharacterEncoding("EUC-KR");
	%>
	
	<jsp:useBean id="m" class="com.bit.vo.MemberVO"/>
	<jsp:setProperty property="*" name="m"/>
	
	
	입력한 회원의 정보 
	<hr>
	<%=m %>
</body>
</html>