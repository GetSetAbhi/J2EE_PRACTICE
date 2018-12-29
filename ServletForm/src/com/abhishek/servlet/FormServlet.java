package com.abhishek.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
//@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("SERVLET INITIALIZED");
		//ServletConfig config=getServletConfig();  
		System.out.println("SERVLET CONFIGS");
		Enumeration<String> paramList = config.getInitParameterNames();
		while (paramList.hasMoreElements()) {
			String param = paramList.nextElement().toString();
			String value = config.getInitParameter(param);
			System.out.println(param + " : " + value);
		}
		
		super.init(config);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("SERVLET CONTEXTS");
		ServletContext context = getServletContext(); 
		Enumeration<String> contextParamList = context.getInitParameterNames();
		while (contextParamList.hasMoreElements()) {
			String param = contextParamList.nextElement().toString();
			String value = context.getInitParameter(param);
			System.out.println(param + " : " + value);
		}
		
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		
		StringBuilder stmt = new StringBuilder("<h1>Welcome ");
		stmt.append(name + " " + lastName + "</h1>");
		
		PrintWriter writer = response.getWriter();
		writer.print("<html><body>");
		writer.print(stmt.toString());
		writer.print("</body></html>");
		writer.close();
	
		System.out.println("REQUEST PARAMETERS");
		Enumeration<String> paramList = request.getParameterNames();
		while (paramList.hasMoreElements()) {
			String param = paramList.nextElement().toString();
			String value = request.getParameter(param);
			System.out.println(param + " : " + value);
		}
		
		System.out.println(getServletInfo());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
