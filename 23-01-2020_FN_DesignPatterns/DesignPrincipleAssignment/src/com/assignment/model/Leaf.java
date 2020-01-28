package com.assignment.model;

public class Leaf implements Component {
	
	private String name;
	private long cost;
	private int area;
	
	public Leaf() {
		
	}
	
	public Leaf(String name, long cost, int area) {
		super();
		this.name = name;
		this.cost = cost;
		this.area = area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	@Override
	public long getArea() {
		return area;
	}
	

}
