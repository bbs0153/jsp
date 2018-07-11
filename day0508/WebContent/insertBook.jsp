<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>도서등록</h2>
	<hr>
	<!-- method(전송방식) get: 파라미터가 url에 노출됨 post: 파라미터가 url에 노출이 안됨(일반적으로 많이 씀) 보안성이  get보다 높음 -->
	<form action="insertBookOK.jsp" method="post"> 
	<table>
	<tr><td>도서번호:</td><td><input type="text" name="bookid"></td></tr>
	<tr><td>도서명:</td><td><input type="text" name="bookname"></td></tr>
	<tr><td>출판사:</td><td><input type="text" name="publisher"></td></tr>
	<tr><td>가격:</td><td><input type="text" name="price"></td></tr>
	</table>
	
	<input type="submit" value ="등록">
	</form>
	


</body>
</html>