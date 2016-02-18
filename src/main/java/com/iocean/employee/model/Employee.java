package com.iocean.employee.model;

import java.time.LocalDate;

public class Employee {

	private Long id;
	private String firstName;
	private String lastName;
	private String SSNumber;
	private double salary;
	private LocalDate engageDate;
	
	public Employee(Long id, String firstName, String lastName, String sSNumber, double salary, LocalDate engageDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		SSNumber = sSNumber;
		this.salary = salary;
		this.engageDate = engageDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSSNumber() {
		return SSNumber;
	}

	public void setSSNumber(String sSNumber) {
		SSNumber = sSNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getEngageDate() {
		return engageDate;
	}

	public void setEngageDate(LocalDate engageDate) {
		this.engageDate = engageDate;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", SSNumber=" + SSNumber
				+ ", salary=" + salary + ", engageDate=" + engageDate + "]";
	}
	
	
}
