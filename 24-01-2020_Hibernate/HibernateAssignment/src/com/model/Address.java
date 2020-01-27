package com.model;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Address {
	
	private String street;
    private String city;
    private String zip;
    private String state;
    
//    @OneToOne(targetEntity = Customer.class)
//    private Customer customer;

//    public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	public Address() {
    }

    public Address(String street, String city, String zip, String state) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
	
}
