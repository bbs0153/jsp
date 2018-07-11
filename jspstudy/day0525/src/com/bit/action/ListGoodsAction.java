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
		GoodsDAO dao = new GoodsDAO();
		ArrayList<GoodsVO> list = dao.listGoods();
		request.setAttribute("list", list);
		return "listGoods.jsp";
	}

}
