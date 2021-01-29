package com.accolite.au;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.accolite.au"})
public class KafakaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafakaDemoApplication.class, args);
	}

}
