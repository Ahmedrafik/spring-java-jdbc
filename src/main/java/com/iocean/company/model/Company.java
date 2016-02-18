package com.iocean.company.model;

import java.util.List;

import com.iocean.employee.model.Employee;

public class Company {
	
	private Long id;
	private String name;
	private List<Employee> employeeList;

	public Company(Long id, String name, List<Employee> employeeList) {
		super();
		this.id = id;
		this.name = name;
		this.employeeList = employeeList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", employeeList=" + employeeList + "]";
	}

	
	
	
}
