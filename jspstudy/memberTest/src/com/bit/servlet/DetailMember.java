package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

/**
 * Servlet implementation class DetailMember
 */
@WebServlet("/DetailMember")
public class DetailMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		MemberVO m = dao.detailMember(id);
		
		String str = "";
		str += "<h2>회원정보<h2><hr>";
		str += "<table>";
		str += "<tr>";
		str += "<td><img width='100' height='100' src='files/"+m.getFname()+"'></td>";
		str += "<td>";
		str += "아이디 : "+m.getId()+"<br>";
		str += "이름 : "+m.getName()+"<br>";
		str += "주소 : "+m.getAddr()+"<br>";
		str += "이메일 : "+m.getEmail()+"<br>";
		str += "나이 : "+m.getAge()+"<br>";
		str += "취미 : "+m.getHobby()+"<br>";
		str += "전화 : "+m.getTel()+"<br>";
		str += "</td>";
		str += "</tr>";
		str += "</table>";
	
		str += "<a href='UpdateMember?id="+m.getId()+"'>수정</a>";
		str += "<a href='DeleteMember?id="+m.getId()+"'>삭제</a>";
		
		response.setContentType("text/html");
		response.setCharacterEncoding("EUC-KR");
		
		PrintWriter out = response.getWriter();
		out.println(str);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
