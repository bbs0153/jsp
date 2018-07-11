<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="updateBookOk.do" method="post">
번호:${b.bookid}<input type="hidden" name="bookid" value=${b.bookid }><br>
제목:<input type="text" name="bookname" value="${b.bookname }"><br>
출판사:<input type="text" name="publisher" value="${b.publisher }"><br>
가격:<input type="number" name="price" value="${b.price}"><br>

<input type="submit" value="수정">
<input type="reset" value="취소">
</form> 
</body>
</html>