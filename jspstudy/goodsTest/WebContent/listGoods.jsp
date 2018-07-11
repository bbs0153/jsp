<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품 목록</h2>
<hr>
	<table border="1" width="60%" align="center">
		<tr>
			<c:forEach var="g" items="${list }">
				<td>
					<a href="detailGoods.do?no=${g.no}">
					<img src="img/${g.fname }" width="50" height="100"></a>
					${g.item}(${g.price })
					</td>
		</c:forEach>
		</tr>
	</table>
	
	<center>${pageStr}</center>
</body>
</html>