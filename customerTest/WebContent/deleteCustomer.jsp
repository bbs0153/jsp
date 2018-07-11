<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
		// 사용자가 요청한 문자는 한글입니다. 라고 설정

		request.setCharacterEncoding("EUC-KR");
		String sql = "DELETE customer WHERE custid=?";

		try {

			int custid = Integer.parseInt(request.getParameter("custid"));

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang",
					"madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);

			int re = pstmt.executeUpdate();

			if (re > 0) {
	%>
	<font color="blue">고객삭제 성공!!!</font>
	<%
		} else {
	%>
	<font color="red">고객삭제 실패!!!</font>
	<%
		}

			pstmt.close();
			conn.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	%>
	<ht> <a href="listCustomer.jsp">고객목록</a>
</body>
</html>