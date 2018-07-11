<%@page import="com.bit.vo.GoodsVO"%>
<%@page import="com.bit.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int no = Integer.parseInt(request.getParameter("no"));

GoodsDAO dao = new GoodsDAO();
GoodsVO g = dao.getGoods(no);
%>

<table border="1">
<tr> 
<td><img src="img/<%=g.getFname()%>"></td>
<td>
상품번호:<%=g.getNo()%>
상품명:<%=g.getItem()%>
가격:<%=g.getPrice()%>
수량:<%=g.getQty()%>
</td>
</tr>
</table>
<a href="updateGoods.jsp?no=<%=g.getNo()%>">수정</a>
<a href="deleteGoods.jsp?no=<%=g.getNo()%>">삭제</a>
<a href="listGoods.jsp">상품목록</a>
</body>
</html>