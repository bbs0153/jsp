<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>큰수 찾기</h2>
<hr>
<form action="maxTest.jsp" method="post">

숫자1:<input type="number" name="a"><br>
숫자2:<input type="number" name="b"><br>

<input type="submit" value="확인">
</form>
<%
if(request.getMethod().equals("POST")){
	
	int a =Integer.parseInt(request.getParameter("a"));
	int b =Integer.parseInt(request.getParameter("b"));
	int c=b;
	
	if(c < a){
		%>
		c=a;
		<%
	}
	%>
		큰수:<%=c%>
	<%	
}


%>



</body>
</html>