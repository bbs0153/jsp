package com.bit.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.action.Action;

/**
 * Servlet implementation class BookController
 */
@WebServlet("*.do")
public class BookController extends HttpServlet {

	HashMap<String, Action> map;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// super.init(config);

		map = new HashMap<String, Action>();

		String path = config.getServletContext().getRealPath("WEB-INF");

		try {

			FileReader fr = new FileReader(path + "/bit.properties");
			Properties prop = new Properties();
			prop.load(fr);
			Set key = prop.keySet();
			Iterator iter = key.iterator();

			while (iter.hasNext()) {

				String svName = (String) iter.next();
				String clsName = prop.getProperty(svName);
				Action obj = (Action) Class.forName(clsName).newInstance();

				map.put(svName, obj);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uri = request.getRequestURI();
		// url은 http부터 다 가져온다
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		Action action = map.get(cmd);
		String view = action.proRequest(request, response);
		request.setAttribute("viewPage", view);
		RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp");
		dispatcher.forward(request, response);
	}
}
