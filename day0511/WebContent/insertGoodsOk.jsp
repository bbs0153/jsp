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
	//�Ѿ�� request�� �ѱ����� ����
	
	GoodsVO g = new GoodsVO();
	g.setNo(Integer.parseInt(request.getParameter("no")));
	g.setItem(request.getParameter("item"));
	g.setPrice(Integer.parseInt(request.getParameter("price")));
	g.setQty(Integer.parseInt(request.getParameter("qty")));
	g.setFname(request.getParameter("fname"));
	//VO�� ���� �Ķ���͸� �־���
	
	GoodsDAO dao = new GoodsDAO();
	int re = dao.insertGoods(g);
	//dao�� insertGoods�޼ҵ带 �̿��Ͽ� Goods���̺� insert���ְ� ������ ������ �޾ƿ�
	if(re > 0) {
		response.sendRedirect("listGoods.jsp");
		//re�� 1���� �Ǻ�(����� �����ߴٸ�)
		//listGoods.jsp�� �̵���
	} else {
		//��ǰ��Ͽ� �����Ͽ��ٸ� �����ߴٴ� �޼����� ����Ѵ�.
%>
		��� ����
		<a href="listGoods.jsp">��ǰ���</a>
<%
	}
%>
</body>
</html>