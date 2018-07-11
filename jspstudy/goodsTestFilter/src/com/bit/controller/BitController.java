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
import com.bit.dao.GoodsDAO;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {

	GoodsDAO dao;
	HashMap<String, Action> map;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BitController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new GoodsDAO();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// super.init(config);

		map = new HashMap<String, Action>();

		String path = config.getServletContext().getRealPath("WEB-INF");
		// bit.properties 파일이 있는
		// WEB-INF의 실제경로를 알아온다
		try {
			FileReader fr = new FileReader(path + "/bit.properties");
			// 환경설정 파일을 메모리로 읽어 들이기 위한
			// 스트림 객체를 생성한다.

			Properties prop = new Properties();
			// key와 value가 한쌍으로 이루어진 파일의 내용을 처리하기 위한 객체 생성

			prop.load(fr);
			// Properties 객체인 prop에 bit.properties 파일의 내용을 읽어 들인다.

			Set key = prop.keySet();
			// Properties 객체로 부터 key(서비스명)을 모두 뽑아와서 변수에 담는다.

			Iterator iter = key.iterator();
			// Set자체로 loop를 수행할 수 없어 set의 내용을 하나씩 꺼내와 반복수행 할 수 있는 Iterator 객체를 생성

			while (iter.hasNext()) {

				String serviceName = (String) iter.next();
				// iterator로 부터 서비스명을 하나씩 뽑아온다
				String clsName = prop.getProperty(serviceName);
				// Properties 객체로 부터 서비스명에 따른 일처리를 위한 action 클래스명을 뽑아온다.
				Action obj = (Action) Class.forName(clsName).newInstance();

				map.put(serviceName, obj);
			}

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
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);

		Action action = map.get(cmd);

		String view = action.proRequest(request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}