
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
		String r = "";	
	
		request.setCharacterEncoding("EUC-KR");
		String name = request.getParameter("name");
		String jumin = request.getParameter("jumin");
		
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


</body>
</html>