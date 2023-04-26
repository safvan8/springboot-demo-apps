package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopAspectJAppApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringAopAspectJAppApplication.class, args);
	}
}

/**
  1) why created runner in this case ?
  
  In this case, the Employeerunner class implements the CommandLineRunner
  interface, which provides a way to execute code after the Spring Boot
  application context has been initialized. This means that the run method of
  the Employeerunner class will be executed after the Spring Boot application
  has started up.
  
  Inside the run method, we have called the saveEmployee method of the
  EmployeeDao class, which saves an employee object to the database. By
  creating a runner, we can ensure that our code is executed at the appropriate
  time during the application lifecycle.
  
  2) who will call this runner ?
  
  The Spring Boot framework will call this runner automatically at the startup
  of the application. It implements the CommandLineRunner interface, which
  provides a single run() method that gets called by Spring Boot at startup
  after the application context is initialized. The run() method contains the
  business logic that we want to execute when the application starts. In this
  case, it calls the saveEmployee() method of the EmployeeDao class to save an
  employee object to the database.
 
 
  3) Which method internally calls all runners ?
  
  In Spring Boot, the SpringApplication class internally calls all the beans
  that implement the CommandLineRunner interface. The run() method of each
  CommandLineRunner bean is called at the end of the application context
  initialization. This method can be used to perform any custom startup logic
  for the application.
  
 */
