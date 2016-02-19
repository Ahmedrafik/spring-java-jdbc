package com.iocean.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocean.employee.model.Employee;
import com.iocean.employee.repository.EmployeeRepository;

//@Service
public class EmployeeFactoryService implements EmployeeService {

	private EmployeeRepository employeRepository;
	
	@Autowired
	public EmployeeFactoryService(EmployeeRepository employeRepository) {
		super();
		this.employeRepository = employeRepository;
	}

	public void saveEmployee(Employee employee) {
		employeRepository.saveEmployee(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeRepository.findAllEmployees();
	}

	public Employee findBySsn(String ssn) {
		return employeRepository.findBySsn(ssn);
	}
	
	public Employee findById(Long id){
		return employeRepository.findById(id);
	}

	public void updateEmployee(Employee employee) {
		employeRepository.updateEmployee(employee);
	}

	public Employee findLastHired() {
		return employeRepository.findLastHired();
	}

}
