package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDAO;

public class LoginOkAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean f = false;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();

		String msg = "로그인에 실패하였습니다";

		if (dao.isMember(id, pwd)) {

			msg = "로그인에 성공하였습니다";
			request.getSession().setAttribute("id", id);
			// 올바른 회원이면 (로그인에 성공하였다면)
			// 그 회원의 아이디를 세션변수에 저장한다.
			// 브라우저를 닫기 전까지 로그인 정보를 유지시키기 위하여
			// 세션변수에 저장한다.
			f = true;
			request.getSession().setAttribute("f", f);
		}
		request.setAttribute("msg", msg);

		return "loginOk.jsp";
	}

}
