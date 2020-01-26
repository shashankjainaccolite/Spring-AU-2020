package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
//import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/apis")
public class Employee{
	
	public static Map<Integer, String> map = new HashMap<>();
	
	@POST
	@Path("/post")
	@Produces("application/json")
	@Consumes("text/plain")
	public String post() {
		List<String> list = Arrays.asList("Spring","AU","2020","Batch","is","going","on");
		for(int i = 0 ; i < list.size() ; i++) {
			map.put(i, list.get(i));
		}
		String s = "The posted map is\n" +map.toString();
		return s;
	}
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public String get() {
		if(map.isEmpty()) {
			return "map is empty so put something with /put api";
		}
		return ("The map present is : " +(map.toString()));
	}
	
	@DELETE
	@Path("/delete")
	@Produces("application/json")
	public String delete(int id) {
		String s = "Map befor deletion is" +map.toString();
		if(map.containsKey(id)) {
			map.remove(id);
			s += "\nMap after deletion is" +map.toString();
			return s;
		} else {
			return "map doesn't have key with this id";
		}
	}
	
	@PUT
	@Path("/put")
	@Produces("application/json")
	public String put(int id) {
		String s = "Map befor change is" +map.toString();
		if(map.containsKey(id)) {
			map.put(id, "String changed");
			s += "\nMap after change is" +map.toString();
			return s;
		} else {
			return "map doesn't have key with this id";
		}
	}
}