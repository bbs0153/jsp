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
String name = "홍길동";
%>
이름 : <%=name %>

<jsp:include page="age2.jsp">
<jsp:param value="2018" name="year"/>
</jsp:include>
<%
String addr = "서울시 마포구 신수동";
%>
주소 : <%=addr %>
</body>
</html>