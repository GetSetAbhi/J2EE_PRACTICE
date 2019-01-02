package com.abhishek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abhishek.controller.AbstractController;
import com.abhishek.model.StudentForm;


@Controller
public class InsertStudentController extends AbstractController {

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String student(Model model) {
		model.addAttribute("studentForm", new StudentForm());
		return "insert.jsp";
	}
	
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("studentForm") StudentForm student, BindingResult result, RedirectAttributes redirectAttribute) {
        
        String message = "";
        if (result.hasErrors()) {
            message = "error with insert student form binding result";
        }
        if (student != null) {
        	message = studentService.insertStudent(student);
        } else {
        	message = "Student form object is null";
        }
		System.out.println(message);
		ModelAndView mv = new ModelAndView("redirect:/list");
		redirectAttribute.addFlashAttribute("message", message);
		return mv;
    }

}
