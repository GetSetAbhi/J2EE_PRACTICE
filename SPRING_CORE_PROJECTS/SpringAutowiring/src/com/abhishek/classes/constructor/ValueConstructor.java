package com.abhishek.classes.constructor;

import com.abhishek.child.Child;

public class ValueConstructor {
	private int id;
	private String name;
	private Child child;

	public ValueConstructor() {

	}

	public ValueConstructor(int id, String name, Child child) {
		this.id = id;
		this.name = name;
		this.setChild(child);
	}
	
	private void showDetails() {
		System.out.println("Id = " + this.id + ", and name = " + this.name);
	}
	
	public void sayHello() {
		String message = "Value Constructor's child class says: " + getChild().getMessage();
		System.out.println(message);
		showDetails();
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
}
