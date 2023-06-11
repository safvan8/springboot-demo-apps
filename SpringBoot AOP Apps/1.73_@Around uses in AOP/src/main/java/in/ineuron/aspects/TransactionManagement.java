package in.ineuron.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	// selects all public methods in the EmployeeDao class with any number of
	// parameters and any return type.
	@Pointcut("execution(public * in.ineuron.dao.EmployeeDao.*())")
	public void p1() {
	}

	@Around("p1()")
	public void aroundAdvice(ProceedingJoinPoint jp) {
		System.out.println("Before Transaction"); // #1 Advice code before method execution
		try {
			Object object = jp.proceed(); // #2 ProceedingJoinPoint is used to invoke the target method
			System.out.println("DATA IS :: " + object); // #4 Advice code after method execution
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After Transaction");// #5
	}

}
