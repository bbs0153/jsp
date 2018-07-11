package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;
import com.oreilly.servlet.MultipartRequest;

public class InsertGoodsOkAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = request.getRealPath("/files");
		MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr");
		int no = Integer.parseInt(multi.getParameter("no"));

		GoodsDAO dao = new GoodsDAO();
		GoodsVO g = new GoodsVO();
		g.setNo(no);
		g.setItem(multi.getParameter("item"));
		g.setPrice(Integer.parseInt(multi.getParameter("price")));
		g.setQty(Integer.parseInt(multi.getParameter("qty")));
		String fname = "";
		g.setFname(fname);

		if (multi.getFile("fname") != null) {

			fname = multi.getFile("fname").getName();
		}
		if (fname != null && !fname.equals("")) {
			g.setFname(fname);
		}

		int re = dao.insertGoods(g);
		if (re > 0) {
			request.setAttribute("msg", "상품 추가 성공");
		} else {
			request.setAttribute("msg", "상품 추가 실패");
		}

		return "insertGoodsOk.jsp";
	}

}
