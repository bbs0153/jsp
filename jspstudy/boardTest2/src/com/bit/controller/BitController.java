package com.bit.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import com.bit.DAO.BoardDAO;
import com.bit.action.Action;
import com.bit.action.DeleteBoardAction;
import com.bit.action.DeleteBoardOKAction;
import com.bit.action.DetailBoardAction;
import com.bit.action.InsertBoardAction;
import com.bit.action.InsertBoardOKAction;
import com.bit.action.ListBoardAction;
import com.bit.action.UpdateBoardAction;
import com.bit.action.UpdateBoardOKAction;
import com.bit.vo.BoardVO;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {

	BoardDAO dao;
	HashMap<String, Action> map;
	// ����� ��û�� ���� ���񽺸��� key�� �ϰ�
	// Ŭ�������� ��ü�� value�� ó���ϱ� ����
	// map�� ����
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BitController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new BoardDAO();
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

		proRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proRequest(request, response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		// ����ڰ� ��û�� URI�� ������ �����Ѵ�.
		// ���࿡ ����ڰ� �۸�Ϻ��⸦ ��û��������
		// uri�� ������ ����.
		// uri : /day0523b/listBoard.do

		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		// uri�� ���� ���񽺸��� �����Ѵ�.
		// listBoard.do
		String view = "";
		// view������(����� ������ jsp�̸���)�� ������ ����
		Action action = null;
		// ������� ��û�� ���� ��ó���� ���� ��ü(ListBoardAction, InsertBoardAction.....)�� �ٶ� ����
		// �������� �ٶ󺼼� �־�� �ϴ� �̰͵��� ������ Action�������̽����� ������ �����Ѵ�.
		action = map.get(cmd);
		// map���� ���� ����ڰ� ��û�� ���񽺸� ���� ��ó���� ���� ��ü�� �̾� �´�.
		// ���� ��� ����ڰ� listBoard.do��� ��û�ߴٸ� action�� new ListBoardAction() ��ü�� �ȴ�.
		view = action.proRequest(request, response);
		// ������ action�� ��ó���� ���� �޼ҵ带 ȣ���Ѵ�.
		// ���� ����ڰ� listBoard.do ��� ��û�ߴٸ� ListBoardAction�� proRequest�� ȣ���Ѵ�.
		// �̶� ������� ��û������ ����ִ� request, ���������� ���� response�� �Ű������� �����Ͽ� "���� ����" �Ѵ�.
		// �����ϰ� ���� ���� ���� �̵��ؾ��� viewPage��(jsp���ϸ�)�� ��ȯ�Ѵ�. �̰��� view�� �����Ѵ�.
		request.setAttribute("viewPage", view);
		RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp");
		// ���� ������� ��û�� ���� ��ó���� action�� ���ؼ� �������� ����� ������ view�������� �̵���Ű�� ����
		// RequestDispatcher ��ü�� �����Ѵ�.
		dispatcher.forward(request, response);
		// ����ڰ� ��û�� ����� �����ֱ� ���� view������(jsp)�� �̵���Ų��.
		// ����� ����� request�� response�� �Ȱ� �̵��Ѵ�.
	}
}
