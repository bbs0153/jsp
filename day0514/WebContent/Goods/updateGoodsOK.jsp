<%@page import="java.io.File"%>
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
		request.setCharacterEncoding("EUC-KR");

		//���Ͼ��ε带 ���� ���� ���ø����̼��� �������� img ������ ������θ� �˾ƿ´�.
		String path = request.getRealPath("/img");
		System.out.println("path:" + path);

		MultipartRequest multi = new MultipartRequest(request, path, "euc-kr");
		//���Ͼ��ε常, multi ==> ����ڰ� ��û�� �Է�������
		//������ �����ϴ� ���

		int no = Integer.parseInt(multi.getParameter("no"));
		GoodsDAO dao = new GoodsDAO();
		String oldFname = dao.getGoods(no).getFname();
		//������ ��ǰ�����̸��� ������ �����Ѵ�.
		//��ǰ������ �����ϸ� ������ ������ �����ϱ� ���Ͽ� �̸� ������ ��� �д�.
		GoodsVO g = new GoodsVO();

		g.setNo(Integer.parseInt(multi.getParameter("no")));
		g.setItem(multi.getParameter("item"));
		g.setPrice(Integer.parseInt(multi.getParameter("price")));
		g.setQty(Integer.parseInt(multi.getParameter("qty")));

		//��ǰ������ �������� �������� ó��
		g.setFname(oldFname);
		String fname = null;
		if (multi.getFile("fname") != null) {

			fname = multi.getFile("fname").getName();

		}
		if (fname != null && !fname.equals("")) {

			g.setFname(fname);
		}

		int re = dao.updateGoods(g);

		if (re == 1) {

			// ������ �����߰�, ���ϵ� �����ߴٸ� ������ ������ �����Ѵ�.
			if (fname != null && !fname.equals("")) {

				File file = new File(path + "/" + oldFname);
				file.delete();
			}

			response.sendRedirect("listGoods.jsp");
		} else {
	%>
	����
	<a href="updateGoods.jsp"></a>
	<%
		}
	%>

</body>
</html>