package com.bit.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDAO;

public class DeleteGoodsAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));

		GoodsDAO dao = new GoodsDAO();

		String path = request.getRealPath("/files");

		String oldFname = dao.getGoods(no).getFname();
		
		int re = dao.deleteGoods(no);
		if (re > 0) {
			File file = new File(path + "/" + oldFname);
			file.delete();
			request.setAttribute("msg", "삭제에 성공했습니다.");
		} else {
			request.setAttribute("msg", "삭제에 실패했습니다.");
		}

		return "deleteGoods.jsp";
	}

}
