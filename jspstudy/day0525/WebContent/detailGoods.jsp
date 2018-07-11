<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="60%">
<tr> 
<td><img src="files/${g.fname}"></td>
<td>
상품번호:${g.no}<br>
상품명:${g.item}<br>
가격:${g.price}<br>
수량:${g.qty}<br>
</td>
</tr>
</table>
<a href="updateGoods.do?no=${g.no}">상품 수정</a>
<a href="deleteGoods.do?no=${g.no}">상품 삭제</a>
</body>
</html>