package com.iocean.employee_java;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.iocean.App;
import com.iocean.company.service.CompanyService;
import com.iocean.employee.factory.EmployeeFactory;
import com.iocean.employee.model.Employee;
import com.iocean.employee.service.EmployeeService;

public class EmployeeJdbcTest{
	
	AbstractApplicationContext context;
	EmployeeService emplService;
	CompanyService companyService;
	EmployeeService employeeJdbcService;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext(App.class);
		companyService = (CompanyService)context.getBean(CompanyService.class);
		employeeJdbcService = (EmployeeService)context.getBean(EmployeeService.class);
		//employeeJdbcService.droptable();
		//employeeJdbcService.createTable();
	}
	
	@Test
	public void testEmployeeInit() throws Exception{
		EmployeeFactory empl = (EmployeeFactory)context.getBean("employeeFactory");
		List<Employee> lionking = empl.getListEmployee();
		assertEquals(6, lionking.size());
	}

	@Test
	public void testSaveEmployee(){
		Employee nala = new Employee(18l, "Nala", "LionQueen", "1596321", 15236.01, LocalDate.of(2014, 10, 20));
		Employee simba = new Employee(1l, "Simba", "TheLionKing", "122345678", 1234.56, LocalDate.of(2015, 11, 26));
		Employee mouphasa = new Employee(2l, "Mouphasa", "TheLionKing", "1245678", 1234.56, LocalDate.of(2016, 01, 26));
		Employee timon = new Employee(3l, "Timon", "TheLionKing", "1223456", 1234.56, LocalDate.of(2006, 01, 02));
		Employee pumba = new Employee(4l, "Pumba", "TheLionKing", "1223478", 1234.56, LocalDate.of(2014, 11, 12));
		Employee skar = new Employee(5l, "Skar", "TheLionKing", "122344278", 1234.56, LocalDate.of(2015, 06, 26));
		Employee rafiki = new Employee(6l, "Rafiki", "TheLionKing", "122655678", 1234.56, LocalDate.of(1984, 11, 26));

		employeeJdbcService.saveEmployee(nala);
		employeeJdbcService.saveEmployee(simba);
		employeeJdbcService.saveEmployee(mouphasa);
		employeeJdbcService.saveEmployee(timon);
		employeeJdbcService.saveEmployee(pumba);
		employeeJdbcService.saveEmployee(skar);
		employeeJdbcService.saveEmployee(rafiki);
		
	}
	
	@Test
	public void testFindAllEmployees(){	
		assertEquals(7,employeeJdbcService.findAllEmployees().size());
	}
	
	@Test
	public void testFindBySsn(){
		assertEquals("Simba", employeeJdbcService.findBySsn("122345678").getFirstName());
	}
	
	@Test
	public void testFindById(){
		assertEquals("Simba", employeeJdbcService.findById(1l).getFirstName());
	}
	
	@Test
	public void testUpdateEmployee(){
		System.out.println("test1 : " + employeeJdbcService);
		Employee zazu = new Employee(2l, "Zazu", "ThelionKing", "13579", 102563.02, LocalDate.of(1569, 06, 21));
		employeeJdbcService.updateEmployee(zazu);
		assertEquals("Zazu", employeeJdbcService.findById(2l).getFirstName());
	}
	
	@Test
	public void testFindLastHired(){
		System.out.println("test : " + employeeJdbcService);
		assertEquals("Mouphasa", employeeJdbcService.findLastHired().getFirstName());
	}
	
	/* Test MockService */
	/*
	@Test
	public void testMockFindAll(){
		assertEquals(null, emplService.findAllEmployees());
	}
	*/
	/* Test Company Service */
	/*
	@Test
	public void testfindAllEmployeesOfaCompany(){
		assertEquals(6, companyService.findAllEmployees().size());
	}
	*/
	@After
	public void close(){
		context.close();
	}
}
