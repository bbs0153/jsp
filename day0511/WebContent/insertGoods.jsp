<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>��ǰ���</h2>
<hr>
<form action="insertGoodsOk.jsp" method="POST">
<table>
	<tr>
		<td>��ǰ��ȣ</td>
		<td><input type="number" min="4" name="no"></td>
	</tr>
	<tr>
		<td>��ǰ��</td>
		<td><input type="text" name="item"></td>
	</tr>
	<tr>
		<td>����</td>
		<td><input type="number" min="1000" name="price"></td>
	</tr>
	<tr>
		<td>����</td>
		<td><input type="number" min="1" name="qty"></td>
	</tr>
	<tr>
		<td>���ϸ�</td>
		<td><input type="text" name="fname"></td>
	</tr>
</table>
<input type="submit" value="���">
<input type="reset" value="���">
</form>
</body>
</html>