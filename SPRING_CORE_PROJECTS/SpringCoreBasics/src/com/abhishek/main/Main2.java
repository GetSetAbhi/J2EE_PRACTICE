package com.abhishek.main;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.abhishek.classes.HelloBeanDefinition;

public class Main2 {
	
	 static Log log = LogFactory.getLog(Main2.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new FileSystemXmlApplicationContext("spring/spring-config.xml");
		HelloBeanDefinition hbd = (HelloBeanDefinition) context.getBean("helloBeanDefinition");
		log.info("SHOWING THE RESULT");
		hbd.showAllMessages();
		
	}

}
