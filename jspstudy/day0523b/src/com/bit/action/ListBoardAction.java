package com.bit.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.DAO.BoardDAO;
import com.bit.vo.BoardVO;

public class ListBoardAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getRealPath("/upload");
		System.out.println(path);
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.listBoard();
		request.setAttribute("list", list);
		return "listBoard.jsp";
	}

}
