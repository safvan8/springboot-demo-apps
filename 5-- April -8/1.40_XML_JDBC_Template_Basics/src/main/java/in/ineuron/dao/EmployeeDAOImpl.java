package in.ineuron.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOImpl implements IEmployeeDAO
{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public EmployeeDAOImpl(JdbcTemplate jdbcTemplate)
	{
		System.out.println("Constructor  autowiring of jdbcTemplate bean...");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertSingleEmployeeRecord(String ename, int eage, double salary)
	{
		// to insert a single record to DB ( non select operation )
		int insertRowCount = jdbcTemplate.update("INSERT INTO EMPLOYEE (ename,eage,esalary)" + "VALUES (?,?,?)", ename,
				eage, salary);

		return insertRowCount;
	}

	@Override
	public int getAllEmpsCount()
	{
		// we specified we need Integer output type
		return jdbcTemplate.queryForObject("SELECT count(*) from Employee", Integer.class);
	}

	@Override
	public String getEmployeeNameById(int eid)
	{
		return jdbcTemplate.queryForObject("SELECT ename FROM employee WHERE eid = ?", String.class, eid);
	}

	@Override
	public Map<String, Object> getSingleEmployeeDetailsWithColumnName(int eid)
	{
		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT eid,ename,eage,esalary FROM employee WHERE eid=?",
				eid);
		return map;
	}

	@Override
	public List<Map<String, Object>> getAllEmployeesDetailAsListOfMapUsingSalary(double esalary)
	{
		List<Map<String, Object>> empRecords = jdbcTemplate
				.queryForList("SELECT eid,ename,eage,esalary FROM employee WHERE esalary<?", esalary);
		return empRecords;
	}
}
