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
import com.abhishek.model.Student;

/**
 * Servlet implementation class UpdateRecordServlet
 */
@WebServlet(name = "UpdateRecordServlet",urlPatterns = {"/update"})
public class UpdateRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecordServlet() {
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
		String studentName = String.valueOf(request.getParameter("studentName"));
		Student student = new Student(id, studentName);
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE student_details set name=? where id=?";
			con = DatabaseUtil.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, student.getName());
			stmt.setInt(2, student.getId());

			int result = stmt.executeUpdate();
			String message = result + " record updated.";
			HttpSession session = request.getSession();
			session.setAttribute("updateMessage", message);
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
