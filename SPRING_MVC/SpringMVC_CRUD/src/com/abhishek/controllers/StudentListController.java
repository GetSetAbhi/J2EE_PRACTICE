package com.abhishek.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abhishek.controller.AbstractController;
import com.abhishek.model.StudentForm;

@Controller
public class StudentListController extends AbstractController{

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String studentList(Model model, @ModelAttribute("message") final String message) {
		List<StudentForm> studentList = studentService.getAllStudents();
		model.addAttribute("studentList", studentList);		
		return "list.jsp";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView studentDelete(@RequestParam("studentId") String studentId, RedirectAttributes redirectAttribute) {
		String message = studentService.deleteStudent(studentId);
		ModelAndView mv = new ModelAndView("redirect:/list");
		redirectAttribute.addFlashAttribute("message", message);
		return mv;
	}
}
