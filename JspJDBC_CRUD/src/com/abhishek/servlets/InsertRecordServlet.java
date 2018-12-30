package com.abhishek.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abhishek.database.DatabaseUtil;

/**
 * Servlet implementation class InsertRecordServlet
 */
@WebServlet(name = "InsertRecordServlet",urlPatterns = {"/insert"})
public class InsertRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String studentId = request.getParameter("studentId");
		int id = Integer.parseInt(studentId);
		String studentName = request.getParameter("studentName");

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "INSERT INTO student_details VALUES(?,?)";
			con = DatabaseUtil.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setString(2, studentName);

			int result = stmt.executeUpdate();
			String message = result + " new record inserted.";
			
			HttpSession session = request.getSession();
			session.setAttribute("insertMessage", message);
			response.sendRedirect("list.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeConnections(null, stmt, con);
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
