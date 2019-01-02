package com.abhishek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abhishek.dao.StudentDao;
import com.abhishek.database.DatabaseUtil;
import com.abhishek.model.StudentForm;

public class DefaultStudentDao implements StudentDao {

	private DatabaseUtil dbUtil;
	
	public DatabaseUtil getDbUtil() {
		return dbUtil;
	}

	public void setDbUtil(DatabaseUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public String insertStudent(StudentForm student) {
		int id = student.getId();
		String studentName = student.getName();

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "INSERT INTO student_details VALUES(?,?)";
			con = dbUtil.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setString(2, studentName);

			int result = stmt.executeUpdate();
			String message = result + " new record inserted.";
			return message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.closeConnections(null, stmt, con);
		}
		return "Something went wrong with insertion";
	}

	@Override
	public List<StudentForm> getAllStudents() {
		List<StudentForm> studentList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM student_details";
			con = dbUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				studentList.add(new StudentForm(id, name));
			} 

			return studentList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.closeConnections(rs, stmt, con);
		}
		return null;
	}

	@Override
	public String deleteStudent(String studentId) {
		int id = Integer.parseInt(studentId);

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "DELETE FROM student_details where id=?";
			con = dbUtil.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);

			int result = stmt.executeUpdate();
			String message = result + " record deleted.";
			return message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.closeConnections(null, stmt, con);
		}
		return "Something went wrong with deletion";
	}

	@Override
	public String updateStudent(StudentForm student) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE student_details set name=? where id=?";
			con = dbUtil.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, student.getName());
			stmt.setInt(2, student.getId());

			int result = stmt.executeUpdate();
			String message = result + " record updated.";
			return message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.closeConnections(null, stmt, con);
		}
		return "Something went wrong with update";
	}
	
	@Override
	public StudentForm getStudent(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM student_details WHERE id=?";
			con = dbUtil.getConnection();
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
			dbUtil.closeConnections(rs, stmt, con);
		}
		return null;
	}

}
