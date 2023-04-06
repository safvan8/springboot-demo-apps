package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.IEmployeeDAO;
import in.ineuron.dto.Employee;

@SpringBootApplication
public class TestApp
{
	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(TestApp.class, args);

		// getting dao bean
		IEmployeeDAO dao = context.getBean(IEmployeeDAO.class);
		try
		{	// Printing the list
			List<Employee> employees = dao.findAllEmployees();
			employees.forEach(System.out::println);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) context).close();
	}
}
