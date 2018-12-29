package com.abhishek.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FormFilter
 */
public class FormFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FormFilter() {
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
		System.out.println("FILTER REQUEST PARAMETERS");
		HttpServletRequest req = (HttpServletRequest) request;
		
		Enumeration<String> paramList = req.getParameterNames();
		while (paramList.hasMoreElements()) {
			String param = paramList.nextElement().toString();
			String value = req.getParameter(param);
			System.out.println(param + " : " + value);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("FORM FILTER CALLED");
	}

}
