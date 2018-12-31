package com.abhishek.classes.constructor;

public class ValueConstructor {
	private int id;
	private String name;

	public ValueConstructor() {

	}

	public ValueConstructor(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void showDetails() {
		System.out.println("Id = " + this.id + ", and name = " + this.name);
	}
}
