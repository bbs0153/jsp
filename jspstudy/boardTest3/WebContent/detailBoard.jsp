<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
��ȣ:${b.no }<br>
������:${b.title }<br>
�ۼ���:${b.writer }<br>
�ۼ���:${b.regdate }<br>
����:<br>
<textarea rows="10" cols="60"> ${b.content }</textarea><br>
����:${b.fname}(${b.fsize})<br>
��ȸ��:${b.hit }<br>
������:${b.ip}<br>

<a href="listBoard.do">�Խ��� ���</a>
<a href="insertBoard.do?no=${b.no}">��� �ޱ�</a>
<a href="updateBoard.do">�� ����</a>
<a href="deleteBoard.do">�� ����</a>

</body>
</html>