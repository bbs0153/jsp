<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page errorPage="error.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	입력정보는 다음과 같습니다.
	<hr>
	이름 :<%=name%><br> 
	나이 :<%=age%><br>

</body>
</html>