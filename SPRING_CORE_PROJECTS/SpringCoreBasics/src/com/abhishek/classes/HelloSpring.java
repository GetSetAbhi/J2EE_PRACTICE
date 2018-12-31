package com.abhishek.classes;

public class HelloSpring {
	
	private String message;
	
	public HelloSpring() {
		
	}
	
	public HelloSpring(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
