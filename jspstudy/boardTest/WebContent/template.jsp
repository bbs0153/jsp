<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td colspan="2"><jsp:include page="top.jsp" /></td>
		</tr>

		<tr>
			<td><jsp:include page="left.jsp" /></td>

			<td><jsp:include page="${viewPage }" /></td>

		</tr>

		<tr>
			<td colspan="2"><jsp:include page="bottom.jsp" /></td>
		</tr>
	</table>
</body>
</html>