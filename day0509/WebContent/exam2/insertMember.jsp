<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
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
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String tel = request.getParameter("tel");

		String[] arr = request.getParameterValues("hobby");
		String hobby = Arrays.toString(arr);

		String sql = "INSERT INTO member values(?,?,?,?,?,?,?,?)";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang",
					"madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, addr);
			pstmt.setString(5, email);
			pstmt.setInt(6, age);
			pstmt.setString(7, hobby);
			pstmt.setString(8, tel);

			int re = pstmt.executeUpdate();

					if (re > 0) {
						%>
						<font color="blue">등록성공!!!</font>
						<%
				} else {
						%>
						<font color="red">등록실패!!!</font>
						<%
		}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	%>
</body>
</html>