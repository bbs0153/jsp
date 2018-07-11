<%@page import="java.io.File"%>
<%@page import="org.omg.CORBA.portable.Delegate"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.dao.BoardDAO"%>
<%@page import="com.vo.BoardVO"%>
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

		String path = request.getRealPath("/file");

		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "EUC-KR");

		int no = Integer.parseInt(multi.getParameter("no"));

		BoardDAO dao = new BoardDAO();

		String oldFname = dao.detailBoard(no, false).getFname();
		int oldFsize = dao.detailBoard(no, false).getFsize();

		BoardVO b = new BoardVO();
		b.setNo(Integer.parseInt(multi.getParameter("no")));
		b.setPwd(multi.getParameter("pwd"));
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setContent(multi.getParameter("content"));
		b.setFname(oldFname);
		b.setFsize(oldFsize);

		String fname = null;

		if (multi.getFile("fname") != null) {

			fname = multi.getFile("fname").getName();
		}

		if (fname != null && !fname.equals("")) {

			b.setFname(fname);
			b.setFsize((int)multi.getFile("fname").length());
		}

		int re = dao.updateBoard(b);

		if (re > 0) {
			if (fname != null && !fname.equals("") && oldFsize > 0) {

				File file = new File(path + "/" + oldFname);
				
				file.delete();

			}
			response.sendRedirect("listBoard.jsp");

		} else {

			out.print("<font color='red'>실패</font>");
			out.print("<a href='listBoard.jsp'>게시물 목록</a>");
		}
	%>

</body>
</html>