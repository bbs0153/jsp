package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.DeptDAO;
import com.bit.vo.DeptVO;

/**
 * Servlet implementation class InsertDept
 */
@WebServlet("/InsertDept")
public class InsertDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertDept() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("EUC-KR");

		String str = "<h2>부서등록</h2><hr>";

		str += "<form action='InsertDept' method='post'>";
		str += "부서번호:<input type='text' name='dno'><br>";
		str += "부서이름:<input type='text' name='dname'><br>";
		str += "부서위치:<input type='text' name='dloc'><br>";
		str += "<input type='submit' value='등록'>";
		str += "<input type='reset' value='취소'>";
		str += "</form>";

		PrintWriter out = response.getWriter();
		out.println(str);
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("EUC-KR");
		DeptVO d = new DeptVO();
		d.setDno(Integer.parseInt(request.getParameter("dno")));
		d.setDname(request.getParameter("dname"));
		d.setDloc(request.getParameter("dloc"));

		DeptDAO dao = new DeptDAO();
		int re = dao.insertDept(d);

		response.setContentType("text/html");
		response.setCharacterEncoding("EUC-KR");

		PrintWriter out = response.getWriter();

		if (re > 0) {

			out.println("성공");

		} else {

			out.println("실패");
		}
	}

}
