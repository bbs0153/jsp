package com.bit.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDAO;

public class DeleteMemberAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();

		String path = request.getRealPath("upload");

		String oldFname = dao.getMember(id).getName();

		int re = dao.deleteMember(id, pwd);

		if (re > 0) {
			File file = new File(path + "/" + oldFname);
			file.delete();
			request.setAttribute("msg", "삭제에 성공하였습니다.");

		} else {

			request.setAttribute("msg", "삭제에 실하였습니다.");
		}

		return "deleteMember.jsp";

	}

}
