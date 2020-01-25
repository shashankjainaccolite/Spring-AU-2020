package com.accolite.au.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accolite.au.services.EmployeeManager;

@ComponentScan(basePackages = "com.accolite.au")
public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		EmployeeManager manager = context.getBean(EmployeeManager.class);
		manager.getAll();
	}

}
