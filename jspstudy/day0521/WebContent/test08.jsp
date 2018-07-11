<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.vo.Person"%>
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
		String msg = (String) session.getAttribute("msg");
		int age = (Integer)session.getAttribute("year");
		double height = (double)session.getAttribute("height");	
		Person p = (Person)session.getAttribute("p");
		ArrayList<String> list = (ArrayList)session.getAttribute("list");
	%>
	
	메세지 : <%=msg %><br>
	나이 : <%=age %><br>
	키 : <%=height %><br>
	Person : <%=p %><br>
	list : <%=list %><br>
	
</body>
</html>