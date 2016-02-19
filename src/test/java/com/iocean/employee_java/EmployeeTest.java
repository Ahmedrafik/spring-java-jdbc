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

public class EmployeeTest {
	
	AbstractApplicationContext context;
	EmployeeService emplService;
	CompanyService companyService;
	
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext(App.class);
		emplService = (EmployeeService)context.getBean(EmployeeService.class);
		companyService = (CompanyService)context.getBean(CompanyService.class);
	}
		
	@Test
	public void testEmployeeInit() throws Exception{
		EmployeeFactory empl = (EmployeeFactory)context.getBean(EmployeeFactory.class);
		List<Employee> lionking = empl.getListEmployee();
		assertEquals(6, lionking.size());
	}
	
	@Test
	public void testSaveEmployee(){
		Employee nala = new Employee(18l, "Nala", "LionQueen", "1596321", 15236.01, LocalDate.of(2014, 10, 20));
		emplService.saveEmployee(nala);
		assertEquals(7, emplService.findAllEmployees().size());
	}
	
	@Test
	public void testFindAllEmployees(){
		assertEquals(6,emplService.findAllEmployees().size());
	}
	
	@Test
	public void testFindBySsn(){
		assertEquals("Simba", emplService.findBySsn("122345678").getFirstName());
		assertEquals("Simba", emplService.findBySsn("7569841232").getFirstName());
	}
	
	@Test
	public void testUpdateEmployee(){
		Employee zazu = new Employee(2l, "Zazu", "ThelionKing", "13579", 102563.02, LocalDate.of(1569, 06, 21));
		emplService.updateEmployee(zazu);
		assertEquals("Zazu", emplService.findById(2l).getFirstName());
	}
	
	@Test
	public void testFindLastHired(){
		assertEquals("Mouphasa", emplService.findLastHired().getFirstName());
		emplService.saveEmployee(new Employee(10l, "test", "ThelionKing", "13579", 102563.02, LocalDate.now()));
		emplService = (EmployeeService)context.getBean(EmployeeService.class);
		assertEquals("test", emplService.findLastHired().getFirstName());
	}

	/* Test MockService */
	
	@Test
	public void testMockFindAll(){
		assertEquals(null, emplService.findAllEmployees());
	}
	
	/* Test Company Service */
	
	@Test
	public void testfindAllEmployeesOfaCompany(){
		assertEquals(6, companyService.findAllEmployees().size());
	}
	
	@After
	public void close(){
		context.close();
	}
	

}
