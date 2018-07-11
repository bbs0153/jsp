package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// String은 view 페이지
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
