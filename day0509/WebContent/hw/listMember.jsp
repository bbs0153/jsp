<%@page import="com.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.MemberDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">ȸ�����</h1>
<hr>
<table border="1" borderColor="red" cellspacing="0" align="center">
<tr align="center">
<td bgcolor="yellow">���̵�</td>
<td bgcolor="yellow">��й�ȣ</td>
<td bgcolor="yellow">�̸�</td>
<td bgcolor="yellow">�ּ�</td>
<td bgcolor="yellow">�̸���</td>
<td bgcolor="yellow">����</td>
<td bgcolor="yellow">���</td>
<td bgcolor="yellow">��ȭ��ȣ</td>
<td bgcolor="yellow"></td>
<td bgcolor="yellow"></td>
</tr>
<%
try{
	Connection conn = ConnectionProvider.getConnection();
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberVO> list = dao.selectAll();
	
	for(MemberVO mv : list){
	%>	
		<tr>
		<td><%=mv.getId()%></td><td><%=mv.getPwd()%></td>
		<td><%=mv.getName()%></td>
		<td><%=mv.getAddr()%></td>
		<td><%=mv.getEmail()%></td>
		<td><%=mv.getAge()%></td>
		<td><%=mv.getHobby()%></td>
		<td><%=mv.getTel()%></td>
		<td><a href="updateMember.jsp?id=<%= mv.getId() %>">����</a>
		<td><a href="deleteMember.jsp?id=<%= mv.getId() %>">����</a>
		</tr>
	<%	
	}
}catch(Exception e){
	System.out.println(e.getMessage());
}
%>
</table>
<td><a href="insertMember.html">�����</a></td>

</body>
</html>