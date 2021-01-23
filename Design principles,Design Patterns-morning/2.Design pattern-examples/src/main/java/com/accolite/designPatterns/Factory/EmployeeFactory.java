package com.accolite.designPatterns.Factory;

import java.util.HashMap;

import com.accolite.designPatterns.entity.Developer;
import com.accolite.designPatterns.entity.Employee;
import com.accolite.designPatterns.entity.Tester;

public class EmployeeFactory {
	  private static HashMap<String, Employee> m = new HashMap<String, Employee>();
	  
	  public static Employee getEmployee(String type) {
	    Employee p = null;
	    if(m.get(type) != null) {
	      p = m.get(type);
	    } else {
	      switch(type) {
	      case "Developer": 
	        System.out.println("Developer Created");
	        p = new Developer();
	        break;
	      case "Tester":
	        System.out.println("Tester Created");
	        p = new Tester();
	        break;
	      default:
	        System.out.println("No Such Employee");
	      }
	      
	      m.put(type, p);
	    }
	    return p;
	  }
	}
