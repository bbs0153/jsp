<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
번호:${b.no }<br>
글제목:${b.title }<br>
작성자:${b.writer }<br>
작성일:${b.regdate }<br>
내용:<br>
<textarea rows="10" cols="60"> ${b.content }</textarea><br>
파일:${b.fname}(${b.fsize})<br>
조회수:${b.hit }<br>
아이피:${b.ip}<br>

<a href="listBoard.do">게시판 목록</a>
<a href="insertBoard.do?no=${b.no}">답글 달기</a>
<a href="updateBoard.do">글 수정</a>
<a href="deleteBoard.do">글 삭제</a>

</body>
</html>