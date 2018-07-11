package com.bit.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bit.DAO.BoardDAO;

public class DeleteBoardOKAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		
		BoardDAO dao = new BoardDAO();
		String path = request.getRealPath("/upload");
		
		String oldFname = dao.getBoard(no, false).getFname();
		int oldFsize = dao.getBoard(no, false).getFsize();
		
		int re = dao.deleteBoard(no, pwd);
		if(re > 0) {
			if(oldFsize > 0) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			request.setAttribute("msg", "삭제 성공");	
		}
		else
			request.setAttribute("msg", "삭제 실패");	
		
		return "deleteBoardOK.jsp";
	}

}
