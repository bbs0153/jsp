
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		
		String path = request.getRealPath("/img");
		System.out.println(path);
	
		MultipartRequest multi = new MultipartRequest(request,path,1024*1024*5,"EUC-KR");

	
	
		String id = multi.getParameter("id");
		String pwd = multi.getParameter("pwd");
		String name = multi.getParameter("name");
		String addr = multi.getParameter("addr");
		String email = multi.getParameter("email");
		int age = Integer.parseInt(multi.getParameter("age"));
		String[] arr = multi.getParameterValues("hobby");
		//배열을 붙여줌
		String hobby = Arrays.toString(arr);
		String tel = multi.getParameter("tel");
		String fname = multi.getFile("fname").getName();
		
		
		
		MemberVO mv = new MemberVO();
		mv.setId(id);		
		mv.setPwd(pwd);		
		mv.setName(name);		
		mv.setAddr(addr);		
		mv.setEmail(email);		
		mv.setAge(age);		
		mv.setHobby(hobby);
		//mv.setHobby(Arrays.toString(multi.getParameterValues("hobby")));
		mv.setTel(tel);		
		mv.setFname(fname);
		
		
		
		MemberDAO dao = new MemberDAO();
		int re = dao.insertMember(mv);
		
		if(re > 0) {
				response.sendRedirect("listMember.jsp");	
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