<%@page import="test.CustomerDAO"%>
<%@page import="test.CustomerVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>

		<tr>
			<td>고객아이디</td>
			<td>고객명</td>
		</tr>

		<%
			CustomerDAO dao = new CustomerDAO();
			ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
			list = dao.selectAll();

			for (CustomerVO cv : list) {
		%>
		<tr>
			<td><%=cv.getId()%></td>
			<td><a href="detailCustomer.jsp?cid=<%=cv.getId()%>"><%=cv.getName()%></a></td>
		</tr>

		<%
			}
		%>



	</table>


</body>
</html>