package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BookDAO;

public class DeleteBookAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookDAO dao = new BookDAO();

		int re = dao.deleteBook(bookid);

		if (re > 0) {
			request.setAttribute("msg", "삭제 성공");
		} else {
			request.setAttribute("msg", "삭제 실패");
		}
		return "deleteBook.jsp";
	}

}
