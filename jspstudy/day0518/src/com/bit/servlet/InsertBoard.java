package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDAO;
import com.bit.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertBoard
 */
@WebServlet("/insertBoard.do")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertBoard() {
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
		String str = "";

		str += "<form action='insertBoard.do' method='post' encType='multipart/form-data'>";
		str += "글제목:<input type='text' name='title'><br>";
		str += "작성자:<input type='text' name='writer'><br>";
		str += "글암호:<input type='password' name='pwd'><br>";
		str += "글내용:<br><textarea rows='10' cols='60' name='content'></textarea><br>";
		str += "파일:<input type='file' name='fname'><br><br>";
		str += "<input type='submit' value='등록'>";
		str += "<input type='reset' value='취소'>";

		str += "</form>";

		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
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

		BoardVO b = new BoardVO();
		b.setFname("");
		b.setFsize(0);
		b.setIp(ip);
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("content"));

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

		BoardDAO dao = new BoardDAO();
		int re = dao.insertBoard(b);

		if (re > 0) {

			out.print("성공");
		} else {

			out.print("실패");

		}

		out.close();

	}

}
