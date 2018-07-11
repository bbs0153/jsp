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
import com.bit.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/UpdateMember")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMember() {
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

		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		MemberVO m = dao.detailMember(id);

		response.setContentType("text/html");
		response.setCharacterEncoding("EUC-KR");

		String str = "<h2>ȸ������ ����</h2><hr>";
		str += "<form action='UpdateMember' method='post' encType='multipart/form-data'><br>";
		str += "���̵�:<input type='hidden' name='id' value='" + m.getId() + "'><br>";
		str += "��й�ȣ:<input type='password' name='pwd' required='required'><br>";
		str += "�̸�:<input type='text' name='name' value='" + m.getName() + "'><br>";
		str += "�ּ�:<input type='text' name='addr' value='" + m.getAddr() + "'><br>";
		str += "�̸���:<input type='email' name='email' value='" + m.getEmail() + "'><br>";
		str += "����:<input type='number' name='age' value='" + m.getAge() + "'><br>";
		str += "���:<input type='text' name='hobby' value='" + m.getHobby() + "'><br>";
		str += "��ȭ��ȣ:<input type='text' name='tel' value='" + m.getTel() + "'><br>";
		str += "÷������:<img width='50' height='50' src='files/" + m.getFname() + "'>"
				+ "<input type='file' name='fname' value='" + m.getFname() + "'><br>";
		str += "<input type='submit' value='����'>";
		str += "<input type='reset' value='���'>";

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

		String path = request.getRealPath("/files");

		MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "EUC-KR");

		MemberVO m = new MemberVO();

		String id = multi.getParameter("id");

		m.setId(id);
		m.setPwd(multi.getParameter("pwd"));
		m.setName(multi.getParameter("name"));
		m.setAddr(multi.getParameter("addr"));
		m.setEmail(multi.getParameter("email"));
		m.setAge(Integer.parseInt(multi.getParameter("age")));
		m.setHobby(multi.getParameter("hobby"));
		m.setTel(multi.getParameter("tel"));

		MemberDAO dao = new MemberDAO();
		String oldFname = dao.detailMember(id).getFname();
		m.setFname(oldFname);

		String fname = null;

		if (multi.getFile("fname") != null) {

			fname = multi.getFile("fname").getName();

		}
		if (fname != null && !fname.equals("")) {

			m.setFname(fname);
		}

		int re = dao.updateMember(m);

		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (re > 0) {
			if (fname != null && !fname.equals("")) {

				File file = new File(path + "/" + oldFname);
				file.delete();

			}
			response.sendRedirect("ListMember");

		} else {

			out.println("����");
		}

	}

}
