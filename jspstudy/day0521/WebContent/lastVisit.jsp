<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
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
		String lastVisit = "ó�� �湮�Դϴ�.";
		Cookie[] arr = request.getCookies();
		if (arr != null) {
			for (Cookie c : arr) {

				if (c.getName().equals("lastVisit")) {
					lastVisit = "������ �湮�ð���"+URLDecoder.decode(c.getValue(),"euc-kr");
				}
			}

		}
		%>
		����,<%=lastVisit %>
		<%

		Date date = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();
		int hours = date.getHours();
		int mitnutes = date.getMinutes();
		int seconds = date.getSeconds();

		//String str = year + "/" + month + "/" + day + "/" + hours + ":" + mitnutes + ":" + seconds;
		String str = year + "��" + month + "��" + day + "��" + hours + "��" + mitnutes + "��" + seconds+"��";
	
		str = URLEncoder.encode(str,"euc-kr");
		Cookie c = new Cookie("lastVisit", str);
		
		response.addCookie(c);
	%>

	<hr>
	<!--  ��Ű���� �̿��Ͽ� �ι�° ���Ŀ� �湮�ϸ� ������ �湮�ߴ� ��¥�� �ð��� ������ ���
	2018�� 5�� 21�� 12�� 44�п� ������ �湮�ϼ̽��ϴ�. -->
</body>
</html>