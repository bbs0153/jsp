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
	request.setCharacterEncoding("euc-kr");
	//넘어온 request가 한글임을 설정
	
	GoodsVO g = new GoodsVO();
	g.setNo(Integer.parseInt(request.getParameter("no")));
	g.setItem(request.getParameter("item"));
	g.setPrice(Integer.parseInt(request.getParameter("price")));
	g.setQty(Integer.parseInt(request.getParameter("qty")));
	g.setFname(request.getParameter("fname"));
	//VO에 받은 파라미터를 넣어줌
	
	GoodsDAO dao = new GoodsDAO();
	int re = dao.insertGoods(g);
	//dao의 insertGoods메소드를 이용하여 Goods테이블에 insert해주고 성공한 개수를 받아옴
	if(re > 0) {
		response.sendRedirect("listGoods.jsp");
		//re가 1인지 판별(등록을 성공했다면)
		//listGoods.jsp로 이동함
	} else {
		//상품등록에 실패하였다면 실패했다는 메세지를 출력한다.
%>
		등록 실패
		<a href="listGoods.jsp">상품목록</a>
<%
	}
%>
</body>
</html>