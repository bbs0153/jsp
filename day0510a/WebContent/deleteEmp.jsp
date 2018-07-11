<%@page import="com.bit.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사원 삭제</title>
</head>
<body>
	<%
		int eno = Integer.parseInt(request.getParameter("eno"));
	
		EmpDAO dao = new EmpDAO();
		int re = dao.deleteEmp(eno);
		
		if(re>0){
			response.sendRedirect("listEmp.jsp");
		} else {
			%>삭제 실패<br>
			<a href="listEmp.jsp">사원목록</a>
			<%
		}
			
	%>
</body>
</html>