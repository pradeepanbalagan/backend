package com.employees.employeedetails.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employees.employeedetails.Model.Employee;

@Repository
public class EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public Employee getEmployee(long employeeId) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Employee) session.get(Employee.class, employeeId);
	}

	public boolean findEmployee(long employeeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, employeeId);
		if (null != emp) {
			return true;
		}
		return false;
	}

	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
	}

}
