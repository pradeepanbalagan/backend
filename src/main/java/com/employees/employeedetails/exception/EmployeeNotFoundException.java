package com.employees.employeedetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	private Long empId;

	public EmployeeNotFoundException(Long empId) {
		super(String.format("%s not found", empId));
		this.empId = empId;

	}

	public Long getEmpId() {
		return empId;
	}

}