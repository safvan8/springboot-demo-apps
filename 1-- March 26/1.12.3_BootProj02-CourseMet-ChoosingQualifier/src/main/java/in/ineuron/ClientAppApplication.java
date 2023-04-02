package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.target.Student;

@SpringBootApplication
public class ClientAppApplication
{
	public static void main(String[] args)
	{
		System.out.println("Container starting...........");
		ApplicationContext appContext = SpringApplication.run(ClientAppApplication.class, args);

		
		System.out.println("-----------Singleton and internal bean instantiataion completed----------\n");
		// getting Target Bean obj and printing the contents
		Student student = appContext.getBean(Student.class);
		student.displayMeterial();
	}

	// static block and Constructor
	static
	{
		System.out.println("ClientAppApplication.class file is loading");
	}

	public ClientAppApplication()
	{
		System.out.println("ClientAppApplication :: Zero paaram constructor");
	}

}
