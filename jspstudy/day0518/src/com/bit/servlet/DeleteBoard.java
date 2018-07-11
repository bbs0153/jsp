package com.bit.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDAO;

/**
 * Servlet implementation class DeleteBoard
 */
@WebServlet("/deleteBoard.do")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String view = "deleteBoard.jsp";
		request.setAttribute("no", request.getParameter("no"));

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");

		BoardDAO dao = new BoardDAO();

		String oldFname = dao.getBoard(no, false).getFname();
		int fsize = dao.getBoard(no, false).getFsize();

		int re = dao.deleteBoard(no, pwd);

		if (re > 0) {
			if (fsize > 0) {
				String path = request.getRealPath("upload");
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			request.setAttribute("msg", "삭제에 성공");

		} else {

			request.setAttribute("msg", "삭제에 실패");
		}

		String view = "deleteBoardOK.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
