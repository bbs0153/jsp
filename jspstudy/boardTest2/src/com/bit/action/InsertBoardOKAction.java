package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.DAO.BoardDAO;
import com.bit.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;

public class InsertBoardOKAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ip = request.getRemoteAddr();
		String path = request.getRealPath("/upload");
		MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "euc-kr");

		BoardDAO dao = new BoardDAO();
		BoardVO b = new BoardVO();
		
		b.setNo(Integer.parseInt(multi.getParameter("no")));
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("content"));
		int fsize = 0;
		String fname = "";
		b.setFname(fname);
		b.setFsize(fsize);
		b.setIp(ip);
	
		if (multi.getFile("fname") != null) {
			fname = multi.getFile("fname").getName();
		}
		if (fname != null && !fname.equals("")) {
			b.setFname(fname);
			b.setFsize((int)multi.getFile("fname").length());
			
		}
		int re = dao.insertBoard(b);
	

		if (re > 0) {
			request.setAttribute("msg", "게시물 등록에 성공했어요");

		} else {
			request.setAttribute("msg", "게시물 등록에 실패했어요");

		}

		return "insertBoardOK.jsp";
	}
}
