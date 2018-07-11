
<%@page import="com.bit.dao.GoodsDAO"%>
<%@page import="com.bit.vo.GoodsVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
int no = Integer.parseInt(request.getParameter("no"));
GoodsDAO dao = new GoodsDAO();
GoodsVO g = dao.getGoods(no);

%>

<form action="updateMemberOK.jsp" method="post" enctype="multipart/form-data">
		
		상품번호:<input type="number" name="no" value="<%=g.getNo()%>"><br> 
		상품명:<input type="text" name="item" value="<%=g.getItem()%>"><br> 
		가격:<input type="number" min="1000" name="price" value="<%=g.getPrice()%>"><br> 
		수량:<input type="number" min="1" name="qty" value="<%=g.getQty()%>"><br> 
		상품사진 :<img src="img/<%=g.getFname() %>" width="30" height="50"><br>
		<input type="file" name="fname" value="<%=g.getFname()%>"><br>
		
		
		<input type="submit" value="확인"><br> 
		<input type="reset" value="취소">


</form>

</body>
</html>