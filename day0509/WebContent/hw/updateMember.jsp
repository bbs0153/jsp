<%@page import="com.vo.MemberVO"%>
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
<h1 align="center">ȸ������</h1>
<hr>
<%
String id = request.getParameter("id");

MemberDAO dao = new MemberDAO();
MemberVO mv = dao.selectMember(id);

String pwd = mv.getPwd();
String name = mv.getName();
String addr = mv.getAddr();
String email = mv.getEmail();
int age = mv.getAge();
String tel = mv.getTel();

%>

<form action="updateMemberOK.jsp" method="post">
	<table>
	<tr><td>���̵�</td><td><input type="text" name="id" value="<%=id%>"></td></tr>
	<tr><td>��й�ȣ</td><td><input type="text" name="pwd" value="<%=pwd%>"></td></tr>
	<tr><td>�̸�</td><td><input type="text" name="name" value="<%=name%>"></td></tr>
	<tr><td>�ּ�</td><td><input type="text" name="addr" value="<%=addr%>"></td></tr>
	<tr><td>�̸���</td><td><input type="text" name="email" value="<%=email%>"></td></tr>
	<tr><td>����</td><td><input type="number" name="age" value="<%=age%>"></td></tr>
	<tr><td>���</td><td>	
	<input type="checkbox" name="hobby" value="������">������ 
	<input type="checkbox" name="hobby" value="����">����
	<input type="checkbox" name="hobby" value="ũ�ν���">ũ�ν��� 
	<input type="checkbox" name="hobby" value="Ŭ���̹�">Ŭ���̹�
	<input type="checkbox" name="hobby" value="�����">�����
	<input type="checkbox" name="hobby" value="�ö��׿䰡">�ö��׿䰡</td></tr>
	<tr><td>��ȭ��ȣ</td><td><input type="text" name="tel" value="<%=tel%>"></td></tr>
	</table>
	<input type="submit" value="���">

</body>
</html>