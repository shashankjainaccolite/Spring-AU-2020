package com.model;

import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String phoneNumber;
	
//	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
//	private Address address;
	
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "street", column = @Column(name="home_street")),
			@AttributeOverride(name = "city", column = @Column(name="home_city")),
			@AttributeOverride(name = "zip", column = @Column(name="home_zip")),
            @AttributeOverride(name = "state", column = @Column(name="home_state"))            
    })
	private Address home_address;
	
	@ElementCollection
	@GenericGenerator(name="sequence_gen", strategy="sequence")
	@CollectionId(columns= {@Column(name="Address_Id")},generator="sequence_gen",type=@Type(type="long"))
	private java.util.Collection<Address> addr_list = new ArrayList<>();
	
	public Customer() {
		
	}
	
	public Customer(String name, String phoneNumber, Address home_address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.home_address = home_address;
	}	
	
	public java.util.Collection<Address> getAddr_list() {
		return addr_list;
	}

	public void setAddr_list(java.util.Collection<Address> addr_list) {
		this.addr_list = addr_list;
	}

	public Address getHome_address() {
		return home_address;
	}

	public void setHome_address(Address home_address) {
		this.home_address = home_address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
