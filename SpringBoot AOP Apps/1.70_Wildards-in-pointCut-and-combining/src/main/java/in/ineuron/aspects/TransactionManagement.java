package in.ineuron.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	@Pointcut("execution(public * in.ineuron.dao.*.saveEmployee())")
	public void saveOperation() {
		// This pointcut matches the execution of all public methods with any return type
		// in the in.ineuron.dao package. The methods must be named saveEmployee.
	}

	@Pointcut("execution(public * in.ineuron.dao.*.deleteEmployee())")
	public void deleteOperation() {
		// This pointcut matches the execution of all public methods with any return type,
		// in the in.ineuron.dao package. The methods must be named deleteEmployee.
	}

	@Pointcut("saveOperation() || deleteOperation()")
	public void operation() {
		// This pointcut combines the saveOperation and deleteOperation pointcuts using the logical OR operator (||).
		// It matches the execution of methods that match either the saveOperation or deleteOperation pointcut.
	}
	
	@Before("operation()")
	public void beginTransaction() {
		// This advice method is executed before the methods matched by the operation pointcut.
		System.out.println("Transaction begin");
	}

	@After("operation()")
	public void commitTransaction() {
		// This advice method is executed after the methods matched by the operation pointcut have finished executing.
		System.out.println("Transaction committed...");
	}
}
