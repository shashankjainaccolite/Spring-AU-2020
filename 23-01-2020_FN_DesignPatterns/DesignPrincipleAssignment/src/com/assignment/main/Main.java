package com.assignment.main;

import java.util.ArrayList;
import java.util.List;

import com.assignment.model.Component;
import com.assignment.model.Composite;
import com.assignment.model.Leaf;

public class Main {
	
	public static void main(String[] args) {
		
		Component flat1 = new Leaf("Flat1", 3000000, 800);
		Component flat2 = new Leaf("Flat2", 4000000, 900);
		Component flat3 = new Leaf("Flat3", 5000000, 1000);
		
		List<Component> list = new ArrayList<>();
		list.add(flat1);
		list.add(flat2);
		list.add(flat3);
		
		Component floor1 = new Composite("Floor1", list);
		Component floor2 = new Composite("Floor2", list);
		Component floor3 = new Composite("Floor3", list);
		Component floor4 = new Composite("Floor4", list);
		
		List<Component> floorList = new ArrayList<>();
		
		floorList.add(floor1);
		floorList.add(floor2);
		floorList.add(floor3);
		floorList.add(floor4);
		
		Component floors = new Composite("Floors", floorList);
		
		Component lift = new Leaf("Lift", 300000, 200);
		Component swimmingPool = new Leaf("Swimming Pool", 200000, 400);
		Component park = new Leaf("Park", 100000, 500);
		
		List<Component> amenitiesList = new ArrayList<>();
		
		amenitiesList.add(lift);
		amenitiesList.add(swimmingPool);
		amenitiesList.add(park);
		
		Component amenities = new Composite("Amenities", amenitiesList);
		
		System.out.println("Cost of floor1 is : " +floor1.getCost());
		System.out.println("Area of floor1 is : " +floor1.getArea());
		System.out.println("Cost of floor2 is : " +floor2.getCost());
		System.out.println("Area of floor2 is : " +floor2.getArea());
		System.out.println("Cost of floor3 is : " +floor3.getCost());
		System.out.println("Area of floor3 is : " +floor3.getArea());
		System.out.println("Cost of floor4 is : " +floor4.getCost());
		System.out.println("Area of floor4 is : " +floor4.getArea());
		
		System.out.println("Cost of all the flat combined is : " +floors.getCost());
		System.out.println("Area of all the flat combined is : " +floors.getArea());
		
		System.out.println("Cost of all the amenities : " +amenities.getCost());
		System.out.println("Area of all the amenities combined is : " +amenities.getArea());
		
		List<Component> building = new ArrayList<>();
		building.add(floors);
		building.add(amenities);
		
		Component Building = new Composite("Building", building);
		
		System.out.println("Cost of entire building including flats and amenities is : " +Building.getCost());
		System.out.println("Area of entire building including flats and amenities is : " +Building.getArea());
	}

}
