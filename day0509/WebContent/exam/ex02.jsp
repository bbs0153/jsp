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
<option>1월</option>
<option>2월</option>
<option>3월</option>
<option>4월</option>
<option>5월</option>
<option>6월</option>
<option>7월</option>
<option>8월</option>
<option>9월</option>
<option>10월</option>
<option>11월</option>
<option>12월</option>
</select><br>
<select>

<%
 
for(int i=1;i<=12;i++){
%>	
	<option><%=i%>월</option>
<%
}
%>
</select>

</body>
</html>