package com.accolite.multithreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SentenceThread extends Thread{
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Book.txt"));
			int sentenceCount = 0;
			String line;
			String delimiters = "?!.";

			while ((line = reader.readLine()) != null) { // Continue reading until end of file is reached
			    for (int i = 0; i < line.length(); i++) {
			        if (delimiters.indexOf(line.charAt(i)) != -1) { // If the delimiters string contains the character
			            sentenceCount++;
			        }
			    }
			}

			reader.close();
			System.out.println("(Through Thread)The number of sentences is " + sentenceCount);

		}catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
