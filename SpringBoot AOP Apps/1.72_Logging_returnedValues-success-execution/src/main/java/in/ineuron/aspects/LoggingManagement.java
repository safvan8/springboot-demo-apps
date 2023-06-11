package in.ineuron.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingManagement {

	// defining pointCut
	@Pointcut("execution(public * in.ineuron.dao.EmployeeDao.*())")
	public void p1() {
	}

	@AfterReturning(value = "p1()", returning = "obj")
	public void logReturnedValues(Object obj) {
		System.out.println("\n Execution success * Logging the retrived employee Id " + obj);

	}

	@After("p1()") // Executed all the time, no matter , success / Failed
	public void emailSetUpCredentials() {
		System.out.println("\n ***I will be executed always @After Annotation***");
	}
}
