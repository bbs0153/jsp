<%@page import="com.bit.vo.EmpVO"%>
<%@page import="com.bit.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사원 상세 정보</title>
</head>
<body>
<%
	int eno = Integer.parseInt(request.getParameter("eno"));
	EmpDAO dao = new EmpDAO();
	EmpVO e = dao.getEmp(eno);
%>
사원번호: <%=e.getEno() %><br>
사원명: <%=e.getEname() %><br>
급여: <%=e.getSal() %><br>
수당: <%=e.getComm() %><br>
입사일: <%=e.getHiredate() %><br>
주민번호: <%=e.getJumin() %><br>
부서번호: <%=e.getDno() %><br>
직책: <%=e.getPosition() %><br>
주소: <%=e.getAddr() %><br>
관리자번호: <%=e.getMgr() %><br>
이메일: <%=e.getEmail() %>
<hr>
<a href="updateEmp.jsp?eno=<%=e.getEno() %>">수정</a>
<a href="deleteEmp.jsp?eno=<%=e.getEno() %>">삭제</a>
</body>
</html>