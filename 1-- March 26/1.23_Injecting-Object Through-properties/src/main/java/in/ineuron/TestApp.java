package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.comps.Employee;

@SpringBootApplication
public class TestApp
{
	public static void main(String[] args)
	{
		ApplicationContext appContxt = SpringApplication.run(TestApp.class, args);
		// Retrieving target bean
		Employee employee = appContxt.getBean(Employee.class);

		System.out.println(employee);
	}
}
