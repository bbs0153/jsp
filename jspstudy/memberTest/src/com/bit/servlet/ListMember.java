package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/ListMember")
public class ListMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("EUC-KR");
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.getMember();
		
		String str = "<h2>회원 목록</h2><hr>";
		str +="<table border='1' width='80%'><tr>";
		str += "<td>아이디</td>";
		str += "<td>이름</td>";
		str += "<td>나이</td><br></tr>";
		
		for(MemberVO m : list) {
			str += "<tr>";
			str += "<td>" + m.getId() + "</td>";
			str += "<td><a href='DetailMember?id="+m.getId()+"'>"+ m.getName() +"</a></td>";
			str += "<td>" + m.getAge() + "</td>";
			str += "</tr>";
		}
	
		str +="</table>";
		str +="<a href = InsertMember>회원추가</a>";
		
		PrintWriter out = response.getWriter();
		out.println(str);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		MemberVO m = new MemberVO();
		m.setId(request.getParameter("id"));
		m.setName(request.getParameter("name"));

		MemberDAO dao = new MemberDAO();
		
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html");
	
	}

}
