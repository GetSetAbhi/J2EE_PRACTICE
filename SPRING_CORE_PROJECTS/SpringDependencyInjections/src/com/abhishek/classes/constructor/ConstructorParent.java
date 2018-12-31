package com.abhishek.classes.constructor;

import com.abhishek.child.Child;

public class ConstructorParent {
	
	private Child child;
	
	public ConstructorParent(Child child) {
		this.child = child;
	}
	
	public void sayHello() {
		String message = "Constructor Parent's child class says: " + this.child.getMessage();
		System.out.println(message);
	}
}
