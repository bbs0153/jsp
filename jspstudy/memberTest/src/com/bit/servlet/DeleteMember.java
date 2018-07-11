package com.bit.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDAO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class DeleteMember
 */
@WebServlet("/DeleteMember")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMember() {
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
		String id = request.getParameter("id");

		String str = "<form action='DeleteMember' method='post'>";

		str += "<input type='hidden' name='id' value='" + id + "'>";
		str += "<input type='password' name='pwd'>";
		str += "<input type='submit' value='삭제'>";
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

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();
		String oldFname = dao.detailMember(id).getFname();
		// 회원의 사진파일명을 변수에 미리 담아둔다.

		int re = dao.deleteMember(id, pwd);

		if (re > 0) {
			String path = request.getRealPath("/files");
			File file = new File(path + "/" + oldFname);
			file.delete();

			response.sendRedirect("ListMember");

		} else {

			response.setContentType("text/html");
			response.setCharacterEncoding("EUC-KR");
			PrintWriter out = response.getWriter();
			out.print("삭제에 실패하였습니다");
			out.println("<a href='ListMember'>회원목록</a>");
			out.close();
		}

	}

}
