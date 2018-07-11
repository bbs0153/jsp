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
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/InsertMember")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMember() {
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
		
		String str = "<h2>회원 등록</h2><hr>";
		str += "<form action='InsertMember' method='post' encType='multipart/form-data'><br>";
		str += "아이디:<input type='text' name='id'><br>";
		str += "비밀번호:<input type='password' name='pwd'><br>";
		str += "이름:<input type='text' name='name'><br>";
		str += "주소:<input type='text' name='addr'><br>";
		str += "이메일:<input type='email' name='email'><br>";
		str += "나이:<input type='number' name='age'><br>";
		str += "취미:<input type='text' name='hobby'><br>";
		str += "전화번호:<input type='text' name='tel'><br>";
		str += "첨부파일:<input type='file' name='fname'><br>";
		str += "<input type='submit' value='확인'>";
		str += "<input type='reset' value='취소'>";
		
		str += "</form>";
		
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
		
		String path = request.getRealPath("/files");
		System.out.println(path);
		
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "EUC-KR");		
		
		MemberVO m = new MemberVO();
		m.setId(multi.getParameter("id"));
		m.setPwd(multi.getParameter("pwd"));
		m.setName(multi.getParameter("name"));
		m.setAddr(multi.getParameter("addr"));
		m.setEmail(multi.getParameter("email"));
		m.setAge(Integer.parseInt(multi.getParameter("age")));
		m.setHobby(multi.getParameter("hobby"));
		m.setTel(multi.getParameter("tel"));
		m.setFname(multi.getFile("fname").getName());
		
		MemberDAO dao = new MemberDAO();
		
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int re = dao.insertMember(m);
		
		if(re>0) {
			
			response.sendRedirect("ListMember");
			
		}else {
			
			out.println("실패");
		}
	
	}

}
