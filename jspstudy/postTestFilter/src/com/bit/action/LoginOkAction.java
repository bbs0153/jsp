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

		String msg = "�α��ο� �����Ͽ����ϴ�";

		if (dao.isMember(id, pwd)) {

			msg = "�α��ο� �����Ͽ����ϴ�";
			request.getSession().setAttribute("id", id);
			// �ùٸ� ȸ���̸� (�α��ο� �����Ͽ��ٸ�)
			// �� ȸ���� ���̵� ���Ǻ����� �����Ѵ�.
			// �������� �ݱ� ������ �α��� ������ ������Ű�� ���Ͽ�
			// ���Ǻ����� �����Ѵ�.
			f = true;
			request.getSession().setAttribute("f", f);
		}
		request.setAttribute("msg", msg);

		return "loginOk.jsp";
	}

}
