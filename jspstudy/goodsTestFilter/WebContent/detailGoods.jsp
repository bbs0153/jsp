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
��ǰ��ȣ:${g.no}<br>
��ǰ��:${g.item}<br>
����:${g.price}<br>
����:${g.qty}<br>
</td>
</tr>
</table>
<a href="updateGoods.do?no=${g.no}">��ǰ ����</a>
<a href="deleteGoods.do?no=${g.no}">��ǰ ����</a>
</body>
</html>