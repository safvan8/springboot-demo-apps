package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;
import in.ineuron.type.ResultView1;
import in.ineuron.type.ResultView2;
import in.ineuron.type.ResultView3;

@SpringBootApplication
public class DaoSpringDataJpa01Application
{

	public static void main(String[] args)
	{
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		// to get name,company and price of vaccines with company  given
		service
		.searchVaccineByCompany("Sinovac Biotech", ResultView2.class)
		.forEach(view -> 
		{	
			System.out.println("name   company    price\n ==========================");
			System.out.println(view.getRegNo() + "      " + view.getCountry() + "    " + view.getPrice());
		});

		((ConfigurableApplicationContext) factory).close();
	}
}
