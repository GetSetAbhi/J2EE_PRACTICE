package com.abhishek.dao;

import java.util.List;

import com.abhishek.model.StudentForm;

public interface StudentDao {
	public String insertStudent(StudentForm student);
	
	public List<StudentForm> getAllStudents();
	
	public String deleteStudent(String studentId);
	
	public String updateStudent(StudentForm student);
	
	public StudentForm getStudent(int id);
}
