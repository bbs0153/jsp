<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="sumTest.jsp" method="post">

 N : <input type="number" name="n"><br>
 
<input type="submit" value="더하기">
</form>
 <%
 
 if(request.getMethod().equals("POST")){
 
 int n = Integer.parseInt(request.getParameter("n"));
 int sum = 0;
 
 for(int i =1; i<=n; i++){
	 
	 sum += i;
 }
 %>
 
 누적합은?<%=sum%>
<%
}
%>
</body>
</html>