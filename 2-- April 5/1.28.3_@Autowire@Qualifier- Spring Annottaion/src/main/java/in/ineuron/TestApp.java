package in.ineuron;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.Student;

@SpringBootApplication
public class TestApp
{

	public static void main(String[] args) throws Exception
	{
		ApplicationContext context = SpringApplication
				.run(TestApp.class, args);

		System.out.println("Beans info are :: " + Arrays.toString(context.getBeanDefinitionNames()));
		
		System.out.println("---------------------------------");
		
		Student student = context.getBean(Student.class);
	
		/// checking which course is injected
		student.getMaterial().getPurchasedMeterial();

		((ConfigurableApplicationContext) context).close();
	}
}
