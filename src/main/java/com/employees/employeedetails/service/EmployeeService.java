package com.employees.employeedetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employees.employeedetails.Model.Employee;
import com.employees.employeedetails.dao.EmployeeDAO;

@Service("employeeService")
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDao;

	@Transactional
	public Employee getEmployee(Long empid) {
		return employeeDao.getEmployee(empid);
	}

	@Transactional
	public boolean findEmployee(Long empid) {
		return employeeDao.findEmployee(empid);
	}

	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
}
