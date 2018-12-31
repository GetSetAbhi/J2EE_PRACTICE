package com.abhishek.classes.setter;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhishek.child.Child;

public class SetterParent {
	private Child child;

	public SetterParent() {
		
	}
	
	public Child getChild() {
		return child;
	}

	@Autowired
	public void setChild(Child child) {
		this.child = child;
	}
	
	public void sayHello() {
		String message = "Setter Parent's child class says: " + getChild().getMessage();
		System.out.println(message);
	}
}
