package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.ApplicationConfiguration;
import model.Point;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		Point point = (Point) context.getBean("point");
		System.out.println("X value is : " +point.getX() + "\nY value is : " +point.getY());
	}

}
