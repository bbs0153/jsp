<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
	<h2>고객목록</h2>
	<table border="1">
		<tr>
			<td>고객번호</td>
			<td>고객명</td>
			<td>주소</td>
			<td>전화</td>
		</tr>
		<%
			try {
				String sql = "SELECT * FROM customer";

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang",
						"madang");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><%=rs.getString(3)%></td>
						<td><%=rs.getString(4)%></td>
						<td><a href="updateCustomer.jsp?custid=<%= rs.getInt(1) %>">수정</a>
						<td><a href="deleteCustomer.jsp?custid=<%= rs.getInt(1) %>">삭제</a>
					</tr>
					<%
				}
					rs.close();
					stmt.close();
					conn.close();
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
		%>
	</table>
	<a href="insertCustomer.jsp">고객 등록</a>
</body>
</html>