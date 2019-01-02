package com.abhishek.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abhishek.model.StudentForm;

public class DatabaseUtil {
	
	public static final String DATABASE_USERNAME = "root";
	public static final String DATABASE_PASSWORD = "1234";
	public static final String DATABASE_NAME = "student";
	public static final String TABLE_NAME = "student_details";
	
	public String getDbConnectionUrl() {
		StringBuilder sb = new StringBuilder("jdbc:mysql://localhost:3306/");
		sb.append(DATABASE_NAME);
		return sb.toString();
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(getDbConnectionUrl(), DATABASE_USERNAME, DATABASE_PASSWORD);
			return con;
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void closeConnections(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public StudentForm getStudent(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM student_details WHERE id=?";
			con = getConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.first();
			return new StudentForm(rs.getInt(1), rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("EXCEPTION OCCURED IN FETCHING STUDENT");
		} finally {
			closeConnections(rs, stmt, con);
		}
		return null;
	}
}
