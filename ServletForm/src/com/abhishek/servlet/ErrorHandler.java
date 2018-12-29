package com.abhishek.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandler
 */
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><body>");
		writer.print("<h1>Hell Yeah Motherfucker Error Handler is in.</h1>");
		
		if (throwable != null) {
			String exceptionName = throwable.getClass().getName();
			String errorMessage = throwable.getMessage();
			
			writer.print("<h1>Exception Name = " + exceptionName + "</h1>");
			writer.print("<h1>Error Message = " + errorMessage+"</h1>");
			writer.print("<h1>Servlet Name = " + servletName+"</h1>");
			
		} else {
			writer.print("<h1>Status Code = " + statusCode + "</h1>");
			writer.print("<h1>Servlet Name = " + servletName+"</h1>");
			writer.print("<h1>Request Url = " + requestUri +"</h1>");
		}
		
		String url = "<h2><a href=\"check.html\">GO TO INPUT PAGE</a></h2>";
		writer.print(url);
		
		writer.print("</body></html>");
		writer.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
