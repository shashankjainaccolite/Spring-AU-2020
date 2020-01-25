package com.accolite.au.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.accolite.au.models.Employee;

@Component
public class EmployeeManager {
	public Employee getEmployeeById(int id) {
		System.out.println("Get Employee By Id called");
		return new Employee();
	}
	public List<Employee> getAll(){
		System.out.println("Get All Employee called");
		Employee e1 = new Employee(1, "Shashank");
		Employee e2 = new Employee(2, "Saurabh");
		Employee e3 = new Employee(3, "Karthik");
		Employee e4 = new Employee(4, "Abhijeet");
		Employee e5 = new Employee(5, "Akshat");
		Employee e6 = new Employee(6, "Dheeraj");
		
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
		employeeList.add(e6);
		
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		
		return employeeList;
	}
}
