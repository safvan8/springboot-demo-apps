package in.ineuron.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.dao.EmployeeDao;

@Component
public class Employeerunner implements CommandLineRunner {

	@Autowired
	private EmployeeDao dao;

	@Override // main----> run() -----> continue with buisness logic
	public void run(String... args) throws Exception {
		System.out.println("Employeerunner.run()...........");

		Integer empId = dao.getEmployee();

		System.out.println("\n Using retrived empId " + empId + "for futher processing.........");
	}
}
