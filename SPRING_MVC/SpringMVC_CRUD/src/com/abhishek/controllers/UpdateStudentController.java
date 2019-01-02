package com.abhishek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abhishek.controller.AbstractController;
import com.abhishek.model.StudentForm;

@Controller
public class UpdateStudentController extends AbstractController {

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("studentId") String studentId, Model model) {

		int id = Integer.parseInt(studentId);
		StudentForm studentData = studentService.getStudent(id);
		model.addAttribute("studentForm", studentData);
		return "update.jsp";
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("studentForm") StudentForm student, BindingResult result,
			RedirectAttributes redirectAttribute) {
		String message = "";
		if (result.hasErrors()) {
			message = "error with update form binding result";
		}
		if (student != null) {
			message = studentService.updateStudent(student);
		} else {
			message = "Student form object is null";
		}
		ModelAndView mv = new ModelAndView("redirect:/list");
		redirectAttribute.addFlashAttribute("message", message);
		return mv;
	}
}
