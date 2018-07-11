package com.bit.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.action.Action;

import oracle.net.aso.r;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, Action> map;
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BitController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		
		map = new HashMap<String, Action>();
		
		try {
			String path = config.getServletContext().getRealPath("WEB-INF");
			FileReader fr = new FileReader(path + "/bit.properties");
			Properties prop = new Properties();
			prop.load(fr);
			Iterator iter = prop.keySet().iterator();
			while(iter.hasNext())
			{
				String svName = (String)iter.next();
				String clsName = prop.getProperty(svName);
				Action obj = (Action)Class.forName(clsName).newInstance();
				map.put(svName, obj);
			}
			
			fr.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}





	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request,response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		
		Action action = map.get(cmd);
		
		String view = action.proRequest(request, response);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher(view);
		
		dispatcher.forward(request, response);
		
	}
}

















