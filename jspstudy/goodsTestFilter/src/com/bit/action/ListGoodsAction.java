package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;

public class ListGoodsAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNUM = 1;
		if (request.getParameter("pageNUM") != null) {

			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		
		
		GoodsDAO dao = new GoodsDAO();
		ArrayList<GoodsVO> list = dao.listGoods(pageNUM);
		request.setAttribute("list", list);
		request.setAttribute("pageStr", dao.getPageStr());
		return "listGoods.jsp";
	}

}
