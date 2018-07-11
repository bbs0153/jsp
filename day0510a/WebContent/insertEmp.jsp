<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사원등록</title>
</head>
<body>
<%
	EmpDAO dao = new EmpDAO();
	ArrayList<Integer> listDno = dao.listDno();
	ArrayList<String> listPosition = dao.listPosition();
	ArrayList<Integer> listMgr = dao.listMgr();

%>
	<h2>사원등록</h2>
	<hr>
	<form action="insertEmpOk.jsp" method="post">
		사원번호 : <input type="number" name="eno"><br>
		사원명 : <input type="text" name="ename"><br>
		급여 : <input type="number" min="0" name="sal"><br>
		수당 :<input type="number" min="0" name="comm"><br>
		입사일 : <input type="date" name="hiredate"><br>
		주민번호 : <input type="text" name="jumin"><br>
		부서번호 : 
		<select name="dno">
			<%
			for(Integer n : listDno) {
				%><option value="<%=n%>"><%=n%></option><%
			}
			%>
		</select><br>
		직책 :
		<%
			for(String p : listPosition) {
				%>
				<input type="radio" name="position" value="<%=p%>"><%=p%>
				<%
			}
		%>
		<br>
		주소 : <input type="text" name="addr"><br>
		관리자번호 :
		<select name="mgr">
			<%
			for(Integer m : listMgr) {
				%><option value="<%=m%>"><%=m%></option>
			<%
			}
			%>
		</select> 
		<br>
		이메일 : <input type="email" name="email"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>