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
		// bit.properties ������ �ִ�
		// WEB-INF�� ������θ� �˾ƿ´�
		try {
			FileReader fr = new FileReader(path + "/bit.properties");
			// ȯ�漳�� ������ �޸𸮷� �о� ���̱� ����
			// ��Ʈ�� ��ü�� �����Ѵ�.

			Properties prop = new Properties();
			// key�� value�� �ѽ����� �̷���� ������ ������ ó���ϱ� ���� ��ü ����

			prop.load(fr);
			// Properties ��ü�� prop�� bit.properties ������ ������ �о� ���δ�.

			Set key = prop.keySet();
			// Properties ��ü�� ���� key(���񽺸�)�� ��� �̾ƿͼ� ������ ��´�.

			Iterator iter = key.iterator();
			// Set��ü�� loop�� ������ �� ���� set�� ������ �ϳ��� ������ �ݺ����� �� �� �ִ� Iterator ��ü�� ����

			while (iter.hasNext()) {

				String serviceName = (String) iter.next();
				// iterator�� ���� ���񽺸��� �ϳ��� �̾ƿ´�
				String clsName = prop.getProperty(serviceName);
				// Properties ��ü�� ���� ���񽺸��� ���� ��ó���� ���� action Ŭ�������� �̾ƿ´�.
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