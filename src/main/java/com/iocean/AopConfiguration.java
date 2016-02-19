package com.iocean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfiguration {
	
	@Before("execution(* com.iocean.*.service.*.*(..))")
	public void logServicesMethodName(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().toShortString());
		System.out.println(joinPoint.getSignature().getName());
	}
	
	@Before("execution(* com.iocean.employee.service.*.*(..))")
	public void logEmployeeServiceMethodName(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().toShortString());
		System.out.println(joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut="execution(* com.iocean.employee.repository.EmployeeFactoryRepository.*(..))",
					throwing="ex")
	public void logEmployeeNotFound(EmployeeNotFoundException ex){
		System.out.println("Employee Not foud !!!!!!!");
	}
	
	@Around("@annotation(myTransactional)")
	public void logAnnotedMethod(ProceedingJoinPoint pjoinPoint, MyTransactional myTransactional) throws Throwable{
		System.out.println("Mode de propagation : " + myTransactional.propagation());
		pjoinPoint.proceed();
		System.out.println("commit de la transaction");
		
		
	}
	
	
	
	
	
	
}
