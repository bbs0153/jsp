<%@page import="com.bit.dao.EmpDAO"%>
<%@page import="com.bit.vo.EmpVO"%>
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

	EmpVO e = new EmpVO();
	e.setEno(Integer.parseInt(request.getParameter("eno")));
	e.setEname(request.getParameter("ename"));
	e.setSal(Integer.parseInt(request.getParameter("sal")));
	e.setComm(Integer.parseInt(request.getParameter("comm")));
	e.setHiredate(request.getParameter("hiredate"));
	e.setJumin(request.getParameter("jumin"));
	e.setDno(Integer.parseInt(request.getParameter("dno")));
	e.setPosition(request.getParameter("position"));
	e.setAddr(request.getParameter("addr"));
	e.setMgr(Integer.parseInt(request.getParameter("mgr")));
	e.setEmail(request.getParameter("email"));
	
	EmpDAO dao = new EmpDAO();
	int re = dao.updateEmp(e);

	if(re > 0) {
		response.sendRedirect("listEmp.jsp");
	} else {
		%>수정 실패
		<hr>
		<a href="listEmp.jsp">사원목록</a>
		<%
		
	}
%>
</body>
</html>