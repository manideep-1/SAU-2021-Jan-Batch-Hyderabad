package com.accolite.designPatterns.examples;

import java.util.List;

import com.accolite.designPatterns.entity.Vehicle;

public class PrototypePatternExample {

//	  public static void main(String[] args) throws CloneNotSupportedException {
	public void run() throws CloneNotSupportedException{
		System.out.println("Created once and cloned using clonable interface");
		Vehicle a = new Vehicle();
	    a.insertData();
	    
	    Vehicle b = (Vehicle) a.clone();
	    List<String> list = b.getVehicleList();
	    list.add("Honda new Amaze");
	    
	    System.out.println(a.getVehicleList());
	    System.out.println(list);
	    
	    b.getVehicleList().remove("Audi A4");
	    System.out.println(list);
	    System.out.println(a.getVehicleList());
	  }

	}