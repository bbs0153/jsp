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
<%
	
	String id = request.getParameter("id");
	
	MemberDAO dao = new MemberDAO();
	MemberVO m = dao.selectMember(id);
	
%>
<h2>ȸ������</h2>
	<hr>
	<form action="updateMemberOk.jsp" method="post">
		���̵� : <input type="text" name="id" value="<%=m.getId()%>"><br>
		��й�ȣ : <input type="password" name="pwd" value="<%=m.getPwd()%>"><br>
		�̸� : <input type="text" name="name" value="<%=m.getName()%>"><br>
		�ּ� : <input type="text" name="addr" value="<%=m.getAddr()%>"><br>
		�̸��� : <input type="email" name="email" value="<%=m.getEmail()%>"><br>
		���� : <input type="number" name="age" value="<%=m.getAge()%>"><br>
		��� : 
		<input type="checkbox" name="hobby" value="������">������
		<input type="checkbox" name="hobby" value="����">����
		<input type="checkbox" name="hobby" value="ũ�ν���">ũ�ν���
		<input type="checkbox" name="hobby" value="Ŭ���̹�">Ŭ���̹�
		<input type="checkbox" name="hobby" value="�������">�������
		<input type="checkbox" name="hobby" value="�ö��׿䰡">�ö��׿䰡
		
		<br>
		��ȭ��ȣ : <input type="tel" name="tel" value="<%=m.getTel()%>"><br>
		<input type="submit" value="���">
		<input type="reset" value="���">
	</form>



</body>
</html>