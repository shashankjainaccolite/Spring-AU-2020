package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Address;
import com.model.Customer;
import com.model.Electronics;
import com.model.Grocery;
import com.model.Order;
import com.model.Product;

public class CRUDOperations {
	
	public static void main(String[] args) {
		
		Address address1 = new Address("xyz", "abc", "2784982", "fhdk");
		Address address2 = new Address("sej", "wer", "3298478", "ldkfj");
		Customer c1 = new Customer("Shashank", "6354932042", address1);
		Customer c2 = new Customer("Dheeraj", "7834023873", address2);
		
		Product p1 = new Product("Shirt", 10, 500);
		Product p2 = new Product("Trouser", 10, 800);
		
		c1.getAddr_list().add(address1);
		c1.getAddr_list().add(address2);
		
		Order o1 = new Order();
		o1.setCustomerId(c1.getId());
		o1.setTotalAmount(3000);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c1);
		session.save(c2);
		session.save(p1);
		session.save(p2);
		session.save(o1);
		System.out.println("Insertion Succesful");
		p1.setCost(1000);
		System.out.println("Updation Succesful");
		session.delete(p2);
		System.out.println("Deletion Succesful");
		
		session.getTransaction().commit();
		session.close();
	}

}
