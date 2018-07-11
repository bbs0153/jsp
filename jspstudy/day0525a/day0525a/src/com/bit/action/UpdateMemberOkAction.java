package com.bit.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;

public class UpdateMemberOkAction implements Action {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		
		String path = request.getRealPath("upliad");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "EUC-KR");
		
		String id = multi.getParameter("id");
		
		String oldFname = dao.getMember(id).getName();
		
		MemberVO m = new MemberVO();
		m.setId(id);
		m.setPwd(multi.getParameter("pwd"));
		m.setName(multi.getParameter("name"));
		m.setAddr(multi.getParameter("addr"));
		m.setEmail(multi.getParameter("email"));
		m.setAge(Integer.parseInt(multi.getParameter("age")));
		m.setHobby(multi.getParameter("hobby"));
		m.setTel(multi.getParameter("tel"));
		m.setFname(oldFname);
		
		String fname = null;
		if(multi.getParameter("fname") != null) {
			fname = multi.getFile("fname").getName();
		}
		if(fname != null && !fname.equals("")) {
			m.setFname(fname);
		}
		
		int re = dao.updateMember(m);
		if(re>0) {
			if(fname != null && !fname.equals("")) {
				
				File file = new File(path +"/"+ oldFname);
				file.delete();
				
			}
			request.setAttribute("msg", "수정에 성공하였습니다");
		}else {
			
			request.setAttribute("msg", "수정에 실패하였습니다");
		}
		
		
		return "updateMemberOk.jsp";
	}

}
