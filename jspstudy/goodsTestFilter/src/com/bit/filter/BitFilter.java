package com.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import oracle.net.aso.e;

/**
 * Servlet Filter implementation class BitFilter
 */
@WebFilter("*.do")
public class BitFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BitFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("filter가 동작함!");
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println("요청한 uri:"+uri);
		System.out.println("============================================");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	} 

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
