
<%@page import="com.dao.MemberDAO"%>
<%@page import="com.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 목록</title>
</head>
<body>
	<table border="1" cellspacing="0">
		<tr>
			<td bgcolor="yellow">아이디</td>
			<td bgcolor="yellow">이름</td>
			<td bgcolor="yellow">주소</td>
			<td bgcolor="yellow">이메일</td>
			
			<td bgcolor="yellow" colspan="2">&nbsp;</td>
		</tr>
		<%
			ArrayList<MemberVO> list = (new MemberDAO()).selectAll();
			for(MemberVO mv : list){
		%>
				<tr>
					<td><%=mv.getId()%></td>
					<td><a href="detailMember.jsp?id=<%=mv.getId()%>"><%=mv.getName()%></a></td>
					<td><%=mv.getAddr()%></td>
					<td><%=mv.getEmail()%></td>
					<td><a href="updateMember.jsp?id=<%=mv.getId()%>">수정</a></td>
					<td><a href="deleteMember.jsp?id=<%=mv.getId()%>">삭제</a></td>							
				</tr>
		<%
			}
		%>
	</table>
	<br>
	<a href="insertMember.jsp">회원 등록</a>
</body>
</html>