package com.model;

import javax.persistence.Entity;

@Entity
public class Grocery extends Product {
	
	private boolean fresh;

	public boolean isFresh() {
		return fresh;
	}

	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}

	
	
}
