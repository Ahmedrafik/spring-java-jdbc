package com.iocean.employee.factory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.iocean.employee.model.Employee;

@Component
public class EmployeeFactory {
	
	private List<Employee> listEmployee = new ArrayList<Employee>();

	@PostConstruct
	public void createListEmployee(){
		Employee simba = new Employee(1l, "Simba", "TheLionKing", "122345678", 1234.56, LocalDate.of(2015, 11, 26));
		Employee mouphasa = new Employee(2l, "Mouphasa", "TheLionKing", "122345678", 1234.56, LocalDate.of(2016, 01, 26));
		Employee timon = new Employee(3l, "Timon", "TheLionKing", "122345678", 1234.56, LocalDate.of(2006, 01, 02));
		Employee pumba = new Employee(4l, "Pumba", "TheLionKing", "122345678", 1234.56, LocalDate.of(2014, 11, 12));
		Employee skar = new Employee(5l, "Skar", "TheLionKing", "122345678", 1234.56, LocalDate.of(2015, 06, 26));
		Employee rafiki = new Employee(6l, "Rafiki", "TheLionKing", "122345678", 1234.56, LocalDate.of(1984, 11, 26));
		
		
		this.listEmployee.add(simba);
		this.listEmployee.add(mouphasa);
		this.listEmployee.add(timon);
		this.listEmployee.add(pumba);
		this.listEmployee.add(skar);
		this.listEmployee.add(rafiki);
	
	}
	
	public List<Employee> getListEmployee(){
		return this.listEmployee;
	}
	
	public void addEmployee(Employee empl){
		this.listEmployee.add(empl);
	}
	
	public void removeEmployee(Employee empl){
		this.listEmployee.remove(empl);
	}
	
	
}
