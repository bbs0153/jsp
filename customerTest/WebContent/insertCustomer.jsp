<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>고객등록</h2>
<hr>

	
	<form action="insertCustomerOK.jsp" method="post">
	<table>
	
	<tr><td>고객번호:</td><td><input type="text" name="custid"></td></tr>
	<tr><td>고객명:</td><td><input type="text" name="name"> </td></tr>
	<tr><td>주소:</td><td><input type="text" name="address"> </td></tr>
	<tr><td>전화:</td><td><input type="text" name="phone"> </td></tr>
	</table>
	
	<input type="submit" value="등록">

	</form>

</body>
</html>