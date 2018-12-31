package com.abhishek.classes.constructor;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhishek.child.Child;

public class ConstructorParent {
	
	@Autowired
	private Child child;

	public ConstructorParent() {
		
	}
	
	public void sayHello() {
		String message = "Constructor Parent's child class says: " + this.child.getMessage();
		System.out.println(message);
	}
	
	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
}
