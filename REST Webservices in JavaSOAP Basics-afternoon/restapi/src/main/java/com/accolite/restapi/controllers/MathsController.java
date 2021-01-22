package com.accolite.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maths")
public class MathsController {

	@GetMapping("/add")
	public Integer add(@RequestParam("num1") Integer num1,
			@RequestParam("num2") Integer num2) {
		return num1+num2;
	}
	@GetMapping("/multiply/{num1}/{num2}")
	public Integer multiply(@PathVariable("num1") Integer num1,
			@PathVariable("num2") Integer num2) {
		return num1*num2;
	}
}
