package com.iocean.company.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocean.employee.model.Employee;
import com.iocean.employee.service.EmployeeService;

@Service
public class CompanyFactoryService implements CompanyService{

	
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostConstruct
	public List<Employee> findAllEmployees(){
		return employeeService.findAllEmployees();
	}
}
