package com.abhishek.annotations.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnotatedFormServlet
 */
@WebServlet(name = "AnnotatedFormServlet",urlPatterns = {"/AnnotatedFormServlet", "/foo", "/bar"})
public class AnnotatedFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnotatedFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
