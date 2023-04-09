package in.ineuron;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.dao.IEmployeeDAO;

public class TestApp
{
	public static void main(String[] args)
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");

		// getting dao bean
		IEmployeeDAO dao = applicationContext.getBean(IEmployeeDAO.class);

		int insertedRows = dao.insertSingleEmployeeRecord("AAAA", 32, 67683.0);
		if (insertedRows == 1)
			System.out.println("Insertion Success");
		else
			System.out.println("Insertion Failed");

		int allEmpsCount = dao.getAllEmpsCount();
		System.out.println("All EMployees count :" + allEmpsCount);

		String empName = dao.getEmployeeNameById(5);
		System.out.println("Employee Name for Id 5 is :" + empName);

		Map<String, Object> empDetails = dao.getSingleEmployeeDetailsWithColumnName(5);
		System.out.println("Full details of eid 5 is :" + empDetails);

		List<Map<String, Object>> allEmpsList = dao.getAllEmployeesDetailAsListOfMapUsingSalary(6000);
		System.out.println("List of All Emps having Salary < 6000: " + allEmpsList);

		((ConfigurableApplicationContext) applicationContext).close();

	}
}
