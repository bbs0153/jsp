<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품등록</h2>
<hr>
<form action="insertGoodsOk.jsp" method="POST">
<table>
	<tr>
		<td>상품번호</td>
		<td><input type="number" min="4" name="no"></td>
	</tr>
	<tr>
		<td>상품명</td>
		<td><input type="text" name="item"></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="number" min="1000" name="price"></td>
	</tr>
	<tr>
		<td>수량</td>
		<td><input type="number" min="1" name="qty"></td>
	</tr>
	<tr>
		<td>파일명</td>
		<td><input type="text" name="fname"></td>
	</tr>
</table>
<input type="submit" value="등록">
<input type="reset" value="취소">
</form>
</body>
</html>