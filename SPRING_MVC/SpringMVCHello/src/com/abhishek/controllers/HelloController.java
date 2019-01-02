package com.abhishek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhishek.child.Child;

@Controller
public class HelloController {
	
	@Autowired
	private Child child;

	@RequestMapping(value= "/hello", method = RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("message", child.getMessage());
		return "jsp/hello.jsp";
	}
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

}
