
<%@page import="java.io.File"%>
<%@page import="com.dao.MemberDAO"%>
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
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();
		//ȸ�� ������ �����ϱ� ���� �������ϸ��� �̸� ��Ƶд�.
		String oldFname = dao.selectMember(id).getFname();
		int re = dao.deleteMember(id, pwd);

		if (re > 0) {
			//���ϻ����� ���Ͽ� ������ �ִ� ������θ� �˾ƿ´�.
			String path = request.getRealPath("/img");
			// ���ϻ����� ���Ͽ� path�� oldfname�� ���� file��ü�� �����Ѵ�.
			File file = new File(path + "/" + oldFname);
			file.delete();
			response.sendRedirect("listMember.jsp");

		} else {

			response.sendRedirect("deleteMember.jsp?id=" + id);
		}
	%>
</body>
</html>