<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0">

<tr>
<td>1</td>
<td>2</td>
<td>3</td>
<td>4</td>
<td>5</td>
<td>6</td>
<td>7</td>
<td>8</td>
<td>9</td>
<td>10</td>
</tr><br>
<%
for(int i=1;i<=30;i++){
%>	
	<%
	if(i%7==1){
	%>
		</tr><tr>
	<%
	}
	%>
		<td><%=i%></td>
	
	
<% 
}
%>

</table>

</body>
</html>