package in.ineuron.comp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import in.ineuron.dto.Employee;

@Repository
@Profile({ "dev", "uat" })
public class MySQLEmployeeDaoImpl implements IEmployeeDAO
{
	private static final String SQL_SELECT_QUERY = "select eid,ename,eage,eaddress from employee";

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Employee> findAllEmployees() throws Exception
	{
		System.out.println("MySQL Code executing.......................\n");
		System.out.println("DataSource Connection is :: " + dataSource.getClass().getName());

		List<Employee> empList = new ArrayList<Employee>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
				ResultSet resultSet = pstmt.executeQuery())
		{
			while (resultSet.next())
			{
				Employee employee = new Employee();
				employee.setEid(resultSet.getInt(1));
				employee.setEname(resultSet.getString(2));
				employee.setEage(resultSet.getInt(3));
				employee.setEaddress(resultSet.getString(4));

				empList.add(employee);
			}

		} catch (SQLException se)
		{
			se.printStackTrace();
			throw se;
		} catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return empList;
	}

	static
	{
		System.out.println("MySQLEmployeeDaoImpl.class file loading............");
	}

	public MySQLEmployeeDaoImpl()
	{
		System.out.println("MySQLEmployeeDaoImpl bean object instantiated.............");
	}
}
