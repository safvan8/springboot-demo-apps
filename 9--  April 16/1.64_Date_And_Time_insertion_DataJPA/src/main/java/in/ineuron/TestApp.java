package in.ineuron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.bo.Customer;
import in.ineuron.service.ICustomerService;

@SpringBootApplication
public class TestApp
{
	public static void main(String[] args)
	{
		ApplicationContext applicationContext = SpringApplication.run(TestApp.class, args);
		ICustomerService service = applicationContext.getBean("serviceLayer", ICustomerService.class);

		// to insert record into DB, use register method
		String saveResult = service.registerCustomer(new Customer("France", "pogab",
				LocalDateTime.of(1992, 11, 14, 0, 1), LocalDate.now(), LocalTime.of(07, 35)));
		System.out.println(saveResult);

		System.out.println("_____________________________________________________________________________________________");
		
		// to retrieve all the existing customer records from DB and display it
		service.displayAllCustomersInfo().forEach(System.out::println);

	}
}
