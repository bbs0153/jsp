package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.DAO.BoardDAO;
import com.bit.action.Action;
import com.bit.action.DetailBoardAction;
import com.bit.action.InsertBoardAction;
import com.bit.action.InsertBoardOKAction;
import com.bit.action.ListBoardAction;
import com.bit.vo.BoardVO;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {

	BoardDAO dao;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BitController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new BoardDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		proRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proRequest(request, response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();

		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		String view = "";
		Action action = null;
		if (cmd.equals("listBoard.do")) {
			action = new ListBoardAction();
		} else if (cmd.equals("insertBoard.do")) {
			 action = new InsertBoardAction();
		} else if (cmd.equals("updateBoard.do")) {
			// action = new UpdateBoardAction();
		}else if (cmd.equals("detailBoard.do")) {
			action = new DetailBoardAction();
		}else if(cmd.equals("insertBoardOK.do")) {
			action = new InsertBoardOKAction();
		}
	

		view = action.proRequest(request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);

	}
}
