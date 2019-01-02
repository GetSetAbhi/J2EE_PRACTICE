package com.abhishek.controller;

import javax.annotation.Resource;

import com.abhishek.services.StudentService;

public abstract class AbstractController {
	
	@Resource(name="studentService")
	protected StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
