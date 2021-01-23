package com.accolite.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.accolite.demo.model.Employee;
import com.accolite.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	static List<Employee> employees=new ArrayList<>();
	@Override
	public String createEmp(Employee employee) {
		employees.add(employee);
		return "Created Successfully";
	}
	@Override
	public Employee getEmpById(int empId)
	{
		Optional<Employee> employee=employees.stream().filter(e->empId==e.getEmpid()).findFirst();
		if(employee.isPresent()) {
			return employee.get();
		}
		else
			return null;
		
	}

}
