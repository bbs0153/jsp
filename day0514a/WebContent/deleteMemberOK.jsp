
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
		//회원 정보를 삭제하기 전에 사진파일명을 미리 담아둔다.
		String oldFname = dao.selectMember(id).getFname();
		int re = dao.deleteMember(id, pwd);

		if (re > 0) {
			//파일삭제를 위하여 파일이 있는 실제경로를 알아온다.
			String path = request.getRealPath("/img");
			// 파일삭제를 위하여 path와 oldfname을 갖고 file객체를 생성한다.
			File file = new File(path + "/" + oldFname);
			file.delete();
			response.sendRedirect("listMember.jsp");

		} else {

			response.sendRedirect("deleteMember.jsp?id=" + id);
		}
	%>
</body>
</html>