<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<select>
<option>1��</option>
<option>2��</option>
<option>3��</option>
<option>4��</option>
<option>5��</option>
<option>6��</option>
<option>7��</option>
<option>8��</option>
<option>9��</option>
<option>10��</option>
<option>11��</option>
<option>12��</option>
</select><br>
<select>

<%
 
for(int i=1;i<=12;i++){
%>	
	<option><%=i%>��</option>
<%
}
%>
</select>

</body>
</html>