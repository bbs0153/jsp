<%@page import="com.bit.vo.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>사원목록</h2>
	<hr>
	<table border="1" width="100%">
	<tr>
	<td>사원번호</td>
	<td>사원명</td>
	<td>부서번호</td>
	</tr>
	
	<%
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.listEmp();
		
		for( EmpVO e : list ){
			%>
				<tr>
					<td><%=e.getEno() %></td>
					<td><a href="detailEmp.jsp?eno=<%=e.getEno()%>"><%= e.getEname() %></a></td>
					<td><%=e.getDno() %></td>
				</tr>
			<%
		}
	%>

	</table>
	<hr>
	<a href="insertEmp.jsp">사원등록</a>
</body>
</html>