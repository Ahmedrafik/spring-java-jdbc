package com.iocean.employee.service;

import java.util.List;

import com.iocean.employee.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);
	
	List<Employee> findAllEmployees();
	
	Employee findBySsn(String ssn);
	
	public Employee findById(Long id);
	
	void updateEmployee(Employee employee);
	
	Employee findLastHired();
	
}
