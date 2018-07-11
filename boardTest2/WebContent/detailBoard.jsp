<%@page import="com.vo.BoardVO"%>
<%@page import="com.dao.BoardDAO"%>
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
int no = Integer.parseInt(request.getParameter("no"));

BoardDAO dao = new BoardDAO();
BoardVO b = dao.detailBoard(no,true);
%>
글번호:<%=b.getNo()%><br>
글제목:<%=b.getTitle()%><br>
작성자:<%=b.getWriter()%><br>
작성일:<%=b.getRegdate()%><br>
조회수:<%=b.getHit()%><br>
글내용:<br>
<textarea rows="10" cols="60" readonly="readonly"><%=b.getContent() %></textarea>
<br>
<%
if(b.getFsize()>0){
	%>
	첨부파일 :<a href="file/<%=b.getFname()%>"> <%=b.getFname()%></a>(<%=b.getFsize()%>)
	<%
	
}
%>

<hr>
<a href="listBoard.jsp">글목록</a>
<a href="updateBoard.jsp?no=<%=b.getNo()%>">수정</a>
<a href="deleteBoard.jsp?no=<%=b.getNo()%>">삭제</a>
</body>
</html>
