package com.accolite.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.demo.model.Employee;
import com.accolite.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")//controller mapping to localhost:3080/employee
public class EmplyeeController {
	@Autowired
	EmployeeService employeeservice;
	//rest-apis
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody @Validated Employee employee) {
		System.out.println(employee);
		String response=employeeservice.createEmp(employee);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/search/{id}")
	public ResponseEntity<Employee> getEmployeeByEmpId(@PathVariable("id") int empId) {
		Employee employee=employeeservice.getEmpById(empId);
		if(Objects.nonNull(employee)) {
			return ResponseEntity.ok(employee);
		}
		else {
			return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/update")
	public void updateEmployee() {
		
	}
	@DeleteMapping("/delete")
	public void deleteEmployee() {
		
	}
}
