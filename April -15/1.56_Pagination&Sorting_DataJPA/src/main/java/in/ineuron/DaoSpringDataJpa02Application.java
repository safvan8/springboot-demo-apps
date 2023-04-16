package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDataJpa02Application
{

	public static void main(String[] args)
	{
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa02Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		// Uncomment one by on  to see outputs
		
		/**
		 * to sort in ascending order ( since we passed true) of price and name
		 * (Var-args)
		 */
//		  service.fetchDetails(true, "price", "name") 
//		  .forEach((vaccine) ->
//		  System.out.println(vaccine.getPrice() + " == " + vaccine.getCountry()));

		/**
		 * sort in ascending order of price, then in asc order of name
		 * print 0 th page, having 3 records in each page
		 */
//		service.fetchDetailsByPageNo(0, 3, true, "price", "name")
//		 .forEach((vaccine) -> 
//		 System.out.println(vaccine.getName() + " " + vaccine.getPrice() + " " + vaccine.getCountry()));

		// to print all records , with 3 records in each page
		// service.fetchDetailsByPagination(3);
		((ConfigurableApplicationContext) factory).close();

		/**
		 * for better understanding of output : disable show-sql from
		 * application.properties
		 */
	}
}
