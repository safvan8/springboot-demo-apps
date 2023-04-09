package in.ineuron.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO
{
	public int insertSingleEmployeeRecord(String ename, int age, double salary);

	public int getAllEmpsCount();

	public String getEmployeeNameById(int eid);

	public Map<String, Object> getSingleEmployeeDetailsWithColumnName(int eid);

	public List<Map<String, Object>> getAllEmployeesDetailAsListOfMapUsingSalary(double esalary);

}
