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
	//상품삭제가 완료되면 해당 이미지 파일을 삭제하도록 합니다.
	String path = request.getRealPath("/img");
	//삭제할 파일객체를 생성한다
	File file = new File(path + "/" + oldFname);
	//파일을 삭제한다.
	file.delete();
	response.sendRedirect("listGoods.jsp");
	
	
}else{
	
	%>
	실패
	<a href="detailGoods.jsp"></a>
	<%
	
}
%>


</body>
</html>