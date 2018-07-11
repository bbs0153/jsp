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
		session.setAttribute("msg", "임연주 바보!!");
		session.setAttribute("year", 2018);
		session.setAttribute("height", 179.8);
		Person p = new Person("변성인", 26);
		session.setAttribute("p", p);

		ArrayList<String> list = new ArrayList<String>();
		list.add("도라지 무침");
		list.add("계란 후라이");
		list.add("카레");
		list.add("불고기");
		list.add("멸치볶음");
		list.add("명란젓");
		list.add("햄");

		session.setAttribute("list", list);
	%>

	세션에 값을 설정하였습니다
	<hr>
	<a href="test08.jsp">세견 값 확인</a>


</body>
</html>