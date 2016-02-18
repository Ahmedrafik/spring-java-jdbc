package com.iocean.employee.repository;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.iocean.EmployeeNotFoundException;
import com.iocean.MyTransactional;
import com.iocean.employee.factory.EmployeeFactory;
import com.iocean.employee.model.Employee;

@Repository
//@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeFactoryRepository implements EmployeeRepository{

	
	private EmployeeFactory employeeFactory;
	private Employee lastHired;
	
	public EmployeeFactory getEmployeeFactory() {
		return employeeFactory;
	}

	@Autowired
	public void setEmployeeFactory(EmployeeFactory employeeFactory) {
		this.employeeFactory = employeeFactory;
	}

	@MyTransactional(propagation="lalala")
	public void saveEmployee(Employee employee) {
		employeeFactory.addEmployee(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeFactory.getListEmployee();
	}

	public Employee findBySsn(String ssn) {
		for(Employee empl : employeeFactory.getListEmployee()){
			if(empl.getSSNumber().equals(ssn)){
				return empl;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public Employee findById(Long id){
		for(Employee empl : employeeFactory.getListEmployee()){
			if(empl.getId().equals(id)){
				return empl;
			}
		}
		return null;
	}

	public void updateEmployee(Employee employee) {
		Employee emplToRemove = this.findById(employee.getId());
		employeeFactory.removeEmployee(emplToRemove);
		this.saveEmployee(employee);
	}

	@PostConstruct
	public void init() {
		LocalDate lastHiredDate = employeeFactory.getListEmployee().get(0).getEngageDate();
		Employee lastHired = employeeFactory.getListEmployee().get(0);
		for(Employee empl : employeeFactory.getListEmployee()){
			if(empl.getEngageDate().isAfter(lastHiredDate)){
				lastHired = empl;
			}
		}
		this.lastHired = lastHired;
	}

	@Override
	public Employee findLastHired() {
		return this.lastHired;
	}
	
	
	

}
