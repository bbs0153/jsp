package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.CommentsDAO;
import com.bit.dao.PostDAO;


public class DetailPostAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int no = Integer.parseInt(request.getParameter("no"));
		PostDAO dao = new PostDAO();
		request.setAttribute("p", dao.getPost(no));
		
		CommentsDAO dao2 = new CommentsDAO();
		request.setAttribute("comment_list", dao2.listComment(no));
		return "detailPost.jsp";
	}

}
