package com.abhishek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.abhishek.classes.constructor.ConstructorParent;
import com.abhishek.classes.constructor.DemoParent;
import com.abhishek.classes.constructor.ValueConstructor;
import com.abhishek.classes.setter.SetterParent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new FileSystemXmlApplicationContext("spring/spring-config.xml");
		ConstructorParent cp = (ConstructorParent) context.getBean("cp");
		SetterParent sp = (SetterParent) context.getBean("sp");
		cp.sayHello();
		sp.sayHello();
		
		ValueConstructor vc = context.getBean(ValueConstructor.class);
		vc.sayHello();
		
		DemoParent dp = context.getBean(DemoParent.class);
		dp.sayHello();
	}

}
