package com.assignment.model;

import java.util.List;

public class Composite implements Component {
	
	private String name;
	private List<Component> list;
	private long cost;
	private long area;
	
	public Composite() {
		
	}
	
	public Composite(String name, List<Component> list) {
		super();
		this.name = name;
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Component> getList() {
		return list;
	}
	public void setList(List<Component> list) {
		this.list = list;
	}
	@Override
	public long getArea() {
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i) instanceof Leaf) {
				area += ((Leaf)list.get(i)).getArea();
			} else {
				if(((Composite)list.get(i)).area == 0) {
					((Composite)list.get(i)).getArea();
				}
				this.area += ((Composite)list.get(i)).area;
			}
		}
		return area;
	}
	@Override
	public long getCost() {
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i) instanceof Leaf) {
				cost += ((Leaf)list.get(i)).getCost();
			} else {
				if(((Composite)list.get(i)).cost == 0) {
					((Composite)list.get(i)).getCost();
				}
				this.cost += ((Composite)list.get(i)).cost;
			}
		}
		return cost;
	}
	
	

}
