<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 상세</h2>
	<hr>
	번호 : ${b.no }
	<br> 제목 : ${b.title }
	<br> 작성자 : ${b.writer }
	<br> 내용 :
	<br>
	<textarea rows="10" cols="60" readonly="readonly">${b.content }</textarea>
	파일 : ${b.fname }(${b.fsize })
	<br> ip주소 : ${b.ip }
	<br> 등록일 : ${b.regdate }
	<br> 조회수 : ${b.hit }
	<br> <a href="updateBoard.do?no=${b.no}">수정</a>
	<br> <a href="deleteBoard.do?no=${b.no}">삭제</a>
	
</body>
</html>