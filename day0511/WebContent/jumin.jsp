
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
				
				r="����ϰ��� ����� �Դϴ�.<br>";
				r= r+"�����׸��� ����,����";
			}
			if(age>=50){
				
				r= r+",�����";
			}
			
			if(gender=='2'){
				
				r=r+",�����,�ڱþ�";
			}
			
		
			r=r+"�Դϴ�.";

		
		}else{
			
			r = "����ϰ��� ����ڰ� �ƴմϴ�.";
		}
		%>
		
		<%=name%>��(<%=age%>)<br>
		<%=r %>


</body>
</html>