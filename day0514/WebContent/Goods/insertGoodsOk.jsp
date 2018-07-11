<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	
	//클라이언트가 선택한 파일을 현재프로젝트를 기준으로 img폴더에 복사==> 파일업로드
	// 파일업로드 기능을 갖고 있는 클래스 cos.jar에 MultiparRequest 클래스를 이용한다.
	
	//파일업로드 하려면 <input type="file">를 태그를 이용한다.
	// 또, <form>태그의 method는 반드시 "post"여야 하고
	// <form>태그에 encType="multipart/form-data"를 반드시 추가해야한다.
	
	
	//파일 업로드를 위한 현재 프로젝트를 기준으로 생성한 img 폴더의 실제경로를 알아온다
	String path = request.getRealPath("/img");
	System.out.println("path:"+path);
	
	MultipartRequest multi = new MultipartRequest(request, path,"euc-kr");
	
	//c:/temp
	
	
	
	GoodsVO g = new GoodsVO();
	g.setNo(Integer.parseInt(multi.getParameter("no")));
	g.setItem(multi.getParameter("item"));
	g.setPrice(Integer.parseInt(multi.getParameter("price")));
	g.setQty(Integer.parseInt(multi.getParameter("qty")));
	// <input type="file">로 오는 것은 파일 이름이 오는 것이 아니라 파일 내용이 오기 떄문에
	// 이것으로 부터 파일이름을 추출하여 vo에 설정해야 한다.
	g.setFname(multi.getFile("fname").getName());
	
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