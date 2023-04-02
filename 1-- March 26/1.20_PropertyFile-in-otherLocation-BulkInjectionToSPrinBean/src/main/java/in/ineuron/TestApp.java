package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comps.Company;

@SpringBootApplication
public class TestApp
{

	public static void main(String[] args)
	{
		ApplicationContext appContxt = SpringApplication.run(TestApp.class, args);
		Company company = appContxt.getBean(Company.class);
		System.out.println(company);
		
		((ConfigurableApplicationContext) appContxt).close();
	}
}
