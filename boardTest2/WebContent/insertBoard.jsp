<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�� �ۼ��ϱ�</h2>
<hr>
<form action="insertBoardOK.jsp" method="post" enctype="multipart/form-data">


����:<input type="text" name="title"><br>
�ۼ���:<input type="text" name="writer"><br>
��й�ȣ:<input type="password" name="pwd"><br>
����:<br>
<textarea name="content" rows="10" cols="60"></textarea><br>
���ϸ�:<input type="file" name="fname"><br>

<input type="submit" value="���">
<input type="reset" value="���">
</form>

</body>
</html>