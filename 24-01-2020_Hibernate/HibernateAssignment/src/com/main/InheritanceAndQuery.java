package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.Address;
import com.model.Customer;
import com.model.Electronics;
import com.model.EmployeeOrder;
import com.model.Grocery;
import com.model.Order;

public class InheritanceAndQuery {
	
	public static void main(String[] args) {
		
		Electronics e1 = new Electronics();
		e1.setName("Television");
		e1.setCost(12000);
		e1.setQuantity(3);
		e1.setPowerConsumed("400W");
		e1.setCompany("Sony");
		
		Grocery g1 = new Grocery();     
		g1.setName("Potato");
		g1.setCost(15);
		g1.setFresh(true);
		g1.setQuantity(200);
		
		Address address1 = new Address("xyz", "abc", "2784982", "fhdk");
		Address address2 = new Address("sej", "wer", "3298478", "ldkfj");
		Customer c1 = new Customer("Shashank", "6354932042", address1);
		Customer c2 = new Customer("Dheeraj", "7834023873", address2);
		
		Order o1 = new Order(c1.getId(), 3000);
		EmployeeOrder eo1 = new EmployeeOrder();
		
		eo1.setCustomerId(c2.getId());
		eo1.setTotalAmount(2000);
		eo1.setAdditionalDiscount(15);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(e1);
		session.save(g1);
		session.save(c1);
		session.save(c2);
		session.save(o1);
		session.save(eo1);
		
		Query query1 = session.createQuery("from Customer where id > 1");
		List<Customer> customers = query1.list();
		
		Query query2 = session.getNamedQuery("Order.byId");
		query2.setInteger(0, 1);
		List<Order> orders = query2.list();
				
		session.getTransaction().commit();
		session.close();
		for(Customer c : customers) {
			System.out.println(c.getId());
		}
		
		System.out.println("Result of query2 : " +orders.size());
	}
}
