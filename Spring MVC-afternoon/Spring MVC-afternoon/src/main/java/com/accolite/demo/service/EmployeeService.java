package com.accolite.demo.service;


import com.accolite.demo.model.Employee;

public interface EmployeeService {
	public String createEmp(Employee employee);
	public Employee getEmpById(int empId);
}
