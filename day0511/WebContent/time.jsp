<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

지금 : <% Date today = new Date(); %>
<% String yoil[] = {"일","월","화","수","목","금","토"}; %>
<%= today.getYear()+1900+"년 "+(today.getMonth()+1)+"월 "+today.getDate()+"일 "%>(<%=yoil[today.getDay()]%>요일)
</body>
</html>