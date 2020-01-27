package com.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmployeeOrder extends Order {
	
	private int eId;
	private int additionalDiscount;
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public int getAdditionalDiscount() {
		return additionalDiscount;
	}
	public void setAdditionalDiscount(int additionalDiscount) {
		this.additionalDiscount = additionalDiscount;
	}
}
