package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = 0;
		String title = "새글 등록";

		if (request.getParameter("no") != null) {
			no = Integer.parseInt(request.getParameter("no"));
			title = "답글 등록";
		}

		request.setAttribute("no", no);
		request.setAttribute("title", title);

		return "insertBoard.jsp";
	}

}
