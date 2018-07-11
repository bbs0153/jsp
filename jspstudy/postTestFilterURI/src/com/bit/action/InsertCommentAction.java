package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.CommentsDAO;
import com.bit.vo.CommentsVO;

public class InsertCommentAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		CommentsVO c = new CommentsVO();

		c.setWriter(request.getParameter("writer"));
		c.setNo(Integer.parseInt(request.getParameter("no")));
		c.setContent(request.getParameter("content"));

		CommentsDAO dao = new CommentsDAO();
		dao.insertComments(c);
		
		request.setAttribute("no", request.getParameter("no"));
		
		return "insertCommentOk.jsp";
	}

}
