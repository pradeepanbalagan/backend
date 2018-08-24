package com.employees.employeedetails.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employeedetails.Model.Employee;
import com.employees.employeedetails.exception.EmployeeNotFoundException;
import com.employees.employeedetails.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// Get an Employee
	@GetMapping("/employees/{id}")
	public Employee getAllEmployees(@PathVariable(value = "id") Long empid) {
		Employee employee = employeeService.getEmployee(empid);
		return employee;
	}

	// update Employee
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable(value = "id") Long empid, @Valid @RequestBody Employee empDetails) {
		if (employeeService.findEmployee(empid)) {

			employeeService.updateEmployee(empDetails);
		} else {
			throw new EmployeeNotFoundException(empid);

		}
	}

}
