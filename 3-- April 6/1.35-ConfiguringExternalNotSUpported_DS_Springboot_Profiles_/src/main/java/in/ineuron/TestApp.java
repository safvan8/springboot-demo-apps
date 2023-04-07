package in.ineuron;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

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
		{ // Printing the list
			List<Employee> employees = dao.findAllEmployees();
			employees.forEach(System.out::println);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) context).close();
	}

	@Autowired
	private Environment env;

	@Profile({ "dev", "uat" })
	@Bean("myExternalDataSource")
	public ComboPooledDataSource getc3p0DataSource() throws Exception
	{
		ComboPooledDataSource cds = new ComboPooledDataSource();
		cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		cds.setUser(env.getProperty("spring.datasource.username"));
		cds.setPassword(env.getProperty("spring.datasource.password"));
		cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		cds.setDataSourceName("spring.datasource.type");
		return cds;
	}
}
