package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;
import com.sun.org.apache.bcel.internal.generic.DADD;

public class InsertMemberOkAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getRealPath("upload");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "euc-kr");

		MemberVO m = new MemberVO();
		m.setId(multi.getParameter("id"));
		m.setPwd(multi.getParameter("pwd"));
		m.setName(multi.getParameter("name"));
		m.setAddr(multi.getParameter("addr"));
		m.setEmail(multi.getParameter("email"));
		m.setAge(Integer.parseInt(multi.getParameter("age")));
		m.setHobby(multi.getParameter("hobby"));
		m.setTel(multi.getParameter("tel"));

		String fname = "";
		if (multi.getFile("fname") != null) {
			fname = multi.getFile("fname").getName();
		}
		m.setFname(fname);

		MemberDAO dao = new MemberDAO();
		int re = dao.insertMember(m);
		if (re > 0) {

			request.setAttribute("msg", "회원 추가 성공");
		} else {

			request.setAttribute("msg", "회원 추가 실패");
		}

		return "insertMemberOk.jsp";
	}

}
