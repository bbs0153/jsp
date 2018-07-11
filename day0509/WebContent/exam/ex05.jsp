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

<%

Date today = new Date();

int year = today.getYear();
int month = today.getMonth();

Date startDay = new Date(year,month,1);
int yoil = startDay.getDay();

int []last= {31,28,31,30,31,30,31,31,30,31,30,31};
int lastDay = last[month];
%>
<h2><%=year+1900%>년 <%=month+1%>월 <%=yoil %></h2>
<table border="1">
	<tr>
	<td>일</td>
	<td>월</td>
	<td>화</td>
	<td>수</td>
	<td>목</td>
	<td>금</td>
	<td>토</td>
	</tr>
	
	<tr>
	<%
	
	for(int j=1; j<=yoil; j++){
		
		%>
		<td>&nbsp;</td>
		<%
	}
	
	for(int i=1; i<=lastDay; i++){
		
		%>
		<td><%=i%></td>
		<%
		
		if((i+yoil)%7==0){
			%>
			</tr><tr>
			<%
		}
	}
	%>
	</tr>

</table>
</body>
</html>