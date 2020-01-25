package com.model;

public class Company {
	
	private String name;
	private int establishedYear;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", establishedYear=" + establishedYear + "]";
	}
	
	

}
