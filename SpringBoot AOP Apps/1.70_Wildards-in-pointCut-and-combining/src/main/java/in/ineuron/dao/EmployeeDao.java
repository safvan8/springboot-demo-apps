package in.ineuron.dao;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	public Double saveEmployee() {
		System.out.println("Employee Object is saved...");
		return null;
		
	}
	
	public Float getEmployee() {
		System.out.println("Employee Retreived from Database");
		return null;
	}
	
	public void deleteEmployee() {
		System.out.println("Record deleted...");
	}
}
