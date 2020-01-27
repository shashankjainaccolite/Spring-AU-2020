package com.model;

import javax.persistence.Entity;

@Entity
public class Electronics extends Product {
	
	private String powerConsumed;
	
	public String getPowerConsumed() {
		return powerConsumed;
	}
	public void setPowerConsumed(String powerConsumed) {
		this.powerConsumed = powerConsumed;
	}
	private String company;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

}
