package com.bit.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.action.Action;
import com.bit.action.DeleteGoodsAction;
import com.bit.action.DetailGoodsAction;
import com.bit.action.InsertGoodsAction;
import com.bit.action.InsertGoodsOkAction;
import com.bit.action.ListGoodsAction;
import com.bit.action.UpdateGoodsAction;
import com.bit.action.UpdateGoodsOkAction;
import com.bit.dao.GoodsDAO;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {

	GoodsDAO dao;
	HashMap<String, Action> map;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BitController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new GoodsDAO();
		map = new HashMap<String, Action>();
		// map에 key에는 사용자가 요청할 서비스명(~~.do, ~~.do ....)을 담고
		// map에 value에는 그 요청에따른 처리할 클래스 객체를 담는다.

		map.put("listGoods.do", new ListGoodsAction());
		map.put("insertGoods.do", new InsertGoodsAction());
		map.put("insertGoodsOK.do", new InsertGoodsOkAction());
		map.put("detailGoods.do", new DetailGoodsAction());
		map.put("updateGoods.do", new UpdateGoodsAction());
		map.put("updateGoodsOK.do", new UpdateGoodsOkAction());
		map.put("deleteGoods.do", new DeleteGoodsAction());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);

		Action action = map.get(cmd);

		String view = action.proRequest(request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}