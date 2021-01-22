package com.accolite.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	@GetMapping("/")
	public String showWelcomMessege() {
		return "Welome You are a rest api developer now!!!";
	}
}
