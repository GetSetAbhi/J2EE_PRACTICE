package com.abhishek.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet(name = "CheckServlet",urlPatterns = {"/check"})
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int number = Integer.parseInt(String.valueOf(request.getParameter("number")));
		
		if (number == 5) {
			throw new ServletException("NUMBER SHOULD NOT BE 5");
		} else if (number == 1) {
			throw new ServletException("NUMBER SHOULD NOT BE 1");
		} else if (number == 6) {
			throw new IOException("NUMBER SHOULD NOT BE 6");
		}
		
		// New location to be redirected
	    String site = new String("http://www.google.com");
	    /*response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site); */
	    response.sendRedirect(site);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
