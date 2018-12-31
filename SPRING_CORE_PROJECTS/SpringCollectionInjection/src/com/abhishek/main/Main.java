package com.abhishek.main;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.abhishek.classes.CollectionsList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new FileSystemXmlApplicationContext("spring/spring-config.xml");
		
		CollectionsList list = context.getBean(CollectionsList.class);
		
		list.getAddressList();
		list.getAddressSet();
		list.getAddressMap();
		
		Properties prop = list.getAddressProp();
		
		Set set = prop.keySet();
		
		Iterator iter = set.iterator();
		
		while (iter.hasNext()) {
			String key = String.valueOf(iter.next());
			System.out.println("Key : " + key + ", Value : " + prop.getProperty(key));
		}
		
	}

}
