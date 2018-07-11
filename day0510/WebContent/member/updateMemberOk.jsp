<%@page import="com.dao.MemberDAO"%>
<%@page import="com.vo.MemberVO"%>
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
	request.setCharacterEncoding("EUC-KR");
	MemberVO m = new MemberVO();
	// 사용자가 입력한 회원의 id를 MemberVO 객체 m의 맴버변수 id에 설정함.
	m.setId(request.getParameter("id"));
	m.setPwd(request.getParameter("pwd"));
	m.setName(request.getParameter("name"));
	m.setAddr(request.getParameter("addr"));
	m.setEmail(request.getParameter("email"));
	m.setAge(Integer.parseInt((request.getParameter("age"))));
	m.setHobby(request.getParameter("hobby"));
	m.setTel(request.getParameter("tel"));

	MemberDAO dao = new MemberDAO();
	int re = dao.updateMember(m);
	if(re>0){
		
		response.sendRedirect("listMember.jsp");
	}else{
		%>
		실패!!!!!
		<hr>
		<a href="listMember.jsp">회원목록</a>
		<%
	}
	
	
%>

</body>
</html>