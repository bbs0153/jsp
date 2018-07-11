<%@page import="com.dao.MemberDAO"%>
<%@page import="com.vo.MemberVO"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		request.setCharacterEncoding("euc-kr");	
	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] arr = request.getParameterValues("hobby");
		//배열을 붙여줌
		String hobby = Arrays.toString(arr);
		String tel = request.getParameter("tel");
		
		MemberVO mv = new MemberVO();
		mv.setId(id);		
		mv.setPwd(pwd);		
		mv.setName(name);		
		mv.setAddr(addr);		
		mv.setEmail(email);		
		mv.setAge(age);		
		mv.setHobby(hobby);		
		mv.setTel(tel);		
		
		MemberDAO dao = new MemberDAO();
		int re = dao.insertMember(mv);
		
		if(re > 0) {
		%>
			등록 성공
			<%
				response.sendRedirect("listMember.jsp");
			%>
		<%		
		} else {
		%>
			등록 실패
		<%		
			
		}
			
	%>
	<hr>
	<a href="listMember.jsp">회원 목록</a>
</body>
</html>