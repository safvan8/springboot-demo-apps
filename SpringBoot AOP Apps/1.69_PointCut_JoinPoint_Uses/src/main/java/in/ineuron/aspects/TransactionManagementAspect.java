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
public class TransactionManagementAspect {

	// Defining a pointcut for the saveEmployee method in the EmployeeDao class
	@Pointcut("execution(public void in.ineuron.dao.EmployeeDao.saveEmployee())")
	public void p1() {
		System.out.println("This will never be executed - method only used for defining poitcut expression");
	}

	@Before("p1()") // JoinPoint
	public void beginTransaction() {
		// This advice will be executed before the method 
		// marked by the p1 pointcut is executed
		System.out.println("Transaction begin");
	}

	@After("p1()") // JoinPoint
	public void commitTransaction() {
		// This advice will be executed after the method 
		// marked by the p1 pointcut has finished executing
		System.out.println("Transaction commited...");
	}
}
