package com.abhishek.classes.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.abhishek.child.DemoChild;

public class DemoParent {
	
	@Autowired
	@Qualifier("child1")
	private DemoChild child;
	
	@Autowired
	@Qualifier("child2")
	private DemoChild child2;
	
	public DemoChild getChild() {
		return child;
	}

	public void setChild(DemoChild child) {
		this.child = child;
	}

	public void sayHello() {
		String message = "Demo Parent's child1 class says: " + this.child.getMessage();
		System.out.println(message);
		message = "Demo Parent's child2 class says: " + getChild2().getMessage();
		System.out.println(message);
	}

	public DemoChild getChild2() {
		return child2;
	}

	public void setChild2(DemoChild child2) {
		this.child2 = child2;
	}

}
