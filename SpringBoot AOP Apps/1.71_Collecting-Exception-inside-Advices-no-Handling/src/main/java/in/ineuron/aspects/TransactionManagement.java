package in.ineuron.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;

@Aspect
@Component
public class TransactionManagement {

	// defining pointCut for any method with no arguments inside EmployeeDao class
	@Pointcut("execution(public void in.ineuron.dao.EmployeeDao.*())")
	public void p1() {
	}

	@Before("p1()") // JoinPoint
	public void beginTransaction() {
		System.out.println("Transaction begin");
	}

	@AfterReturning("p1()") // JoinPoint
	public void commitTransaction() {
		System.out.println("Transaction commited... if No Exceptions thrown");
	}

	@AfterThrowing(value = "p1()", throwing = "obj") // for catching in throwable
	public void rollBack(Throwable obj) {
		System.out.println("Transaction rollbacked..." + obj.getMessage());
		System.out.println("I can just collect exception for Logging ,but can't handle exception");
	}

	@After("p1()") // Executed all the time, no matter , success / Failed
	public void emailSetUpCredentials() {
		System.out.println("***I will be executed always @After Annotation***");
	}
}
