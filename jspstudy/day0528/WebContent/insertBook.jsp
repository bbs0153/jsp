<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="insertBookOk.do" method="post">
번호:<input type="number" name="bookid"><br>
제목:<input type="text" name="bookname"><br>
출판사:<input type="text" name="publisher"><br>
가격:<input type="number" name="price"><br>

<input type="submit" value="추가">
<input type="reset" value="취소">
</form> 
</body>
</html>