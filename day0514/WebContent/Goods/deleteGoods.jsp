<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%



int no = Integer.parseInt(request.getParameter("no"));
GoodsDAO dao = new GoodsDAO();
String oldFname = dao.getGoods(no).getFname();
int re = dao.deleteGoods(no);

if(re>0){
	//��ǰ������ �Ϸ�Ǹ� �ش� �̹��� ������ �����ϵ��� �մϴ�.
	String path = request.getRealPath("/img");
	//������ ���ϰ�ü�� �����Ѵ�
	File file = new File(path + "/" + oldFname);
	//������ �����Ѵ�.
	file.delete();
	response.sendRedirect("listGoods.jsp");
	
	
}else{
	
	%>
	����
	<a href="detailGoods.jsp"></a>
	<%
	
}
%>


</body>
</html>