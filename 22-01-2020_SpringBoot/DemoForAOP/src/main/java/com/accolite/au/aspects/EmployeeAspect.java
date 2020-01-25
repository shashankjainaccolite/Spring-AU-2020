package com.accolite.au.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	
	public static long start;
	
	@Before("execution(* com.accolite.au.services.EmployeeManager.getAll(..))")
	public void logBeforV1(JoinPoint joinPoint) {
		start = System.currentTimeMillis();
		System.out.println("EmployeeAspect.logBeforeV1() : " +joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.accolite.au.services.EmployeeManager.getAll(..))")
	public void logAfterV1(JoinPoint joinPoint) {
		System.out.println("Method Execution Time is : " +(System.currentTimeMillis() - start + "ms"));
		System.out.println("EmployeeAspect.logAfterV1() : " +joinPoint.getSignature().getName());
	}
	
}
