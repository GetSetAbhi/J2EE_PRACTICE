package com.abhishek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.abhishek.classes.HelloSpring;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext("spring/spring-config.xml");
		HelloSpring hello = (HelloSpring) context.getBean("helloSpring");
		System.out.println(hello.getMessage());
		
	}

}
