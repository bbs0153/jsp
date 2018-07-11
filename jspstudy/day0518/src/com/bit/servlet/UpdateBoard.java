package com.bit.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDAO;
import com.bit.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateBoard
 */
@WebServlet("/updateBoard.do")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBoard() {
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
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		BoardVO b = dao.getBoard(no, false);

		request.setAttribute("b", b);
		String view = "updateBoard.jsp";
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
		request.setCharacterEncoding("euc-kr");

		String path = request.getRealPath("/upload");
		System.out.println(path);
		String ip = request.getRemoteAddr();

		MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr");

		BoardDAO dao = new BoardDAO();
		BoardVO b = new BoardVO();
		int no = Integer.parseInt(multi.getParameter("no"));

		String oldFname = dao.getBoard(no, false).getFname();
		int oldFsize = dao.getBoard(no, false).getFsize();

		b.setIp(ip);
		b.setNo(no);
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("content"));
		b.setFname(oldFname);
		b.setFsize(oldFsize);

		String fname = null;
		if (multi.getFile("fname") != null) {

			fname = multi.getFile("fname").getName();
		}
		if (fname != null && !fname.equals("")) {

			b.setFname(fname);
			b.setFsize((int) multi.getFile("fname").length());
		}
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();

		int re = dao.updateBoard(b);

		if (re > 0) {
			if (fname != null && !fname.equals("") && oldFsize > 0) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			out.print("성공");
		} else {

			out.print("실패");

		}

		out.close();

	}

}
