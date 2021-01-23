package com.accolite.designPatterns;

import com.accolite.designPatterns.examples.FlyWeightPatternExample;
import com.accolite.designPatterns.examples.PrototypePatternExample;

public class DesignPattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("Prototype Design Pattern example:");
		new PrototypePatternExample().run();
		System.out.println("FlyWeight Design Pattern example:");
		new FlyWeightPatternExample().run();
		
	}
//	new FlyWeightPatternExamlple();

}
