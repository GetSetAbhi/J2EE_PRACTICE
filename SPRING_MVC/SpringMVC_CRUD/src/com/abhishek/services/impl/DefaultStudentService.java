package com.abhishek.services.impl;

import java.util.List;

import com.abhishek.dao.StudentDao;
import com.abhishek.model.StudentForm;
import com.abhishek.services.StudentService;

public class DefaultStudentService implements StudentService {

	private StudentDao studentDao;

	@Override
	public String insertStudent(StudentForm student) {
		return studentDao.insertStudent(student);
	}
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<StudentForm> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public String deleteStudent(String studentId) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(studentId);
	}

	@Override
	public String updateStudent(StudentForm student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}

	@Override
	public StudentForm getStudent(int id) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(id);
	}

}
