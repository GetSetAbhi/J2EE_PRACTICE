package com.abhishek.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhishek.database.DatabaseUtil;

/**
 * Servlet implementation class StudentListServlets
 */
@WebServlet(name = "StudentListServlet",urlPatterns = {"/list"})
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StudentListServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM student_details";
			con = DatabaseUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			if (rs != null) {
				out.println("<h1>Student Details</h1>");
				out.println("<table><tr><th><font color='green'>Student Id</font></th><th><font color='green'>Student Name</font></th></tr>");
				if(rs.next()) {
					String fn = rs.getString(1);
					String ln = rs.getString(2);
				
					out.println("<tr><td>"+fn+"</td><td>"+ln+"</td></tr>");
				} else {
					out.println("</table>");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeConnections(rs, stmt, con);
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
