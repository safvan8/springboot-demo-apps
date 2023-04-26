package in.ineuron.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.dao.EmployeeDao;

@Component // Annotates that this class is a Spring Component
public class Employeerunner implements CommandLineRunner {

	@Autowired // Autowires the EmployeeDao object to this class
	private EmployeeDao dao;

	//main----> run() -----> continue with buisness logic : @Spring
	@Override // Indicates that this method is being overridden from its superclass
	public void run(String... args) throws Exception { // Main method that runs the program
		dao.saveEmployee(); // Calls the saveEmployee() method from the EmployeeDao class
	}

}