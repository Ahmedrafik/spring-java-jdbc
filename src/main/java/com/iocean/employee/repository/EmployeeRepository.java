package com.iocean.employee.repository;

import java.util.List;
import com.iocean.employee.model.Employee;

public interface EmployeeRepository {

	void saveEmployee(Employee employee);
	
	List<Employee> findAllEmployees();
	
	Employee findBySsn(String ssn);
	
	Employee findById(Long id);
	
	void updateEmployee(Employee employee);
	
	Employee findLastHired();
}
