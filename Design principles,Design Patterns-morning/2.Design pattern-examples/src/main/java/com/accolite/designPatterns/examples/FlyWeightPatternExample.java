package com.accolite.designPatterns.examples;

import java.util.Random;

import com.accolite.designPatterns.Factory.EmployeeFactory;
import com.accolite.designPatterns.entity.Employee;

public class FlyWeightPatternExample {

	  private static String employeeType[] = {"Developer", "Tester"};
	  private static String skills[] = {"Java", "C++", ".Net", "Python"};
	  
//	  public static void main(String[] args) {
	  public void run() {
		System.out.println("Created once and modified according to intresic and extrensic properties");
	    for(int i = 0; i < 10; i++) {
	      Employee e = EmployeeFactory.getEmployee(getRandEmployee());
	      
	      e.assignSkill(getRandSkill());
	      
	      e.task();
	    }
	  }
	  
	  public static String getRandEmployee() {
	    Random r = new Random();
	    int randInt = r.nextInt(employeeType.length);
	    
	    return employeeType[randInt];
	  }
	  
	  public static String getRandSkill() {
	    Random r = new Random();
	    int randInt = r.nextInt(skills.length);
	    
	    return skills[randInt];
	  }

	}