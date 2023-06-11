package in.ineuron.dao;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	public Integer getEmployee() {
		System.out.println("\n Employee retirived from DataBase...");
		return 313; // returning integer
	}
}
