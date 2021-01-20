package com.accolite.multithreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class WordCount{
	public void wcmethod() throws IOException {
	try {
		 String line;  
	        int count = 0;  
	          
	        //Opens a file in read mode  
	        FileReader file = new FileReader("Book.txt");  
	        BufferedReader br = new BufferedReader(file);  
	              
	        //Gets each line till end of file is reached  
	        while((line = br.readLine()) != null) {  
	            //Splits each line into words  
	            String words[] = line.split(" ");  
	            //Counts each word  
	            count = count + words.length;  
	        }  
	          
	        System.out.println("Number of words present in given file: " + count);  
	        br.close(); 
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}

}
