
<%@page import="java.util.Date"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>무료 암건진 대상자 판별</h2>
	<hr>
	
	<form action="checkup2.jsp" method="post">

		이름:<input type="text" name="name"><br> 주민번호:<input
			type="text" name="jumin"> <input type="submit" value="확인">
	</form>

	<%
	
	//사용자의 서비스 요청방식이 GET인지 POST인지 알아보자
	
	String method = request.getMethod();
	
	request.setCharacterEncoding("EUC-KR");
	String name = request.getParameter("name");
	String jumin = request.getParameter("jumin");	
	
	if(method.equals("POST")){
		String r = "";	
	
		Date today = new Date();
		int year = today.getYear()+1900;
		
		int user_year = Integer.parseInt(jumin.substring(0, 2))+1900;
		int age = year - user_year;
		char gender = jumin.charAt(7);
		
		if(year%2 == user_year%2){
			
			if(age>=40){
				
				r="무료암검진 대상자 입니다.<br>";
				r= r+"검진항목은 위암,간암";
			}
			if(age>=50){
				
				r= r+",대장암";
			}
			
			if(gender=='2'){
				
				r=r+",유방암,자궁암";
			}
			
		
			r=r+"입니다.";

		
		}else{
			
			r = "무료암검진 대상자가 아닙니다.";
		}
		%>
		<%=name%>님(<%=age%>)<br>
		<%=r %>
		<% 
		}
		%>



</body>
</html>