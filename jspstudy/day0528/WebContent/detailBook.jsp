<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>å �� ����</h2>
<hr>
<table border="1" width="60%">
<tr><td>��ȣ</td><td>${b.bookid}</td></tr>
<tr><td>����</td><td>${b.bookname }</td></tr>
<tr><td>���ǻ�</td><td>${b.publisher }</td></tr>
<tr><td>����</td><td>${b.price }</td></tr>
</table>
<a href="updateBook.do?bookid=${b.bookid}">å  ����</a>
<a href="deleteBook.do?bookid=${b.bookid}">å ����</a>
</body>
</html>