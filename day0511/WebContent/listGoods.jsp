<%@page import="com.bit.vo.GoodsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품목록</h2>
<hr>

	<%
		GoodsDAO dao = new GoodsDAO();
	    ArrayList<GoodsVO> list = dao.listGoods();
	%>
	
	<table border="1" width="80%">
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>가격</td>
		</tr>
		<%
			for(GoodsVO g : list){
				%>
						<tr>
							<td><%=g.getNo()%></td>
							<td><a href="detailGoods.jsp?no=<%=g.getNo()%>"><%=g.getItem()%></a></td>
							<td><%=g.getPrice()%></td>
						</tr>
				<%
			}
		%>
	</table>

<a href="insertGoods.jsp">상품 등록</a>

</body>
</html>