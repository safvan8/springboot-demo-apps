package in.ineuron.dao;

import org.springframework.stereotype.Component;

@Component // Annotates that this class is a Spring Component
public class EmployeeDao
{
	public void saveEmployee() // Method to save an employee
	{
		System.out.println("Employee Object is saved...");
	}

}
