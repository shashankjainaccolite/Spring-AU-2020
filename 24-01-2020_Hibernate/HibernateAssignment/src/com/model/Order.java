package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedQuery(name="Order.byId", query="from Order where orderId > ?0")
@Table(name="Order_Table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int orderId;
	
	public Order() {
		
	}
	
	public Order(int customerId, int totalAmount) {
		super();
		this.customerId = customerId;
		this.totalAmount = totalAmount;
	}
	private int customerId;
	private int totalAmount;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}
