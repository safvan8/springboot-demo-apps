// Importing required packages
package in.ineuron.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Declaring the class as an aspect
@Aspect
@Component
public class TransactionManagement {
	
	// Defining a pointcut for the saveEmployee method in the EmployeeDao class
	@Pointcut("execution(public void in.ineuron.dao.EmployeeDao.saveEmployee())")
	public void p1() {
		System.out.println("Point cut 1");
	}
	
	// This advice will be executed before the method marked by the p1 pointcut is executed
	@Before("p1()")
	public void beginTransaction() {
		System.out.println("Transaction begin");
	}
	
	// This advice will be executed after the method marked by the p1 pointcut has finished executing
	@After("p1()")
	public void commitTransaction() {
		System.out.println("Transaction commited...");
	}
}
