package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDataJpa01Application
{

	public static void main(String[] args)
	{
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		// to delete CoronaVaccine object by name
		service.deleteVaccineByName("covaxin");

		// to count number of a specific country
		long numOfUSA = service.CountNumOfCountries("USA");
		System.out.println("No. of count of USA in DB table :" + numOfUSA);

		// to check company name exists or not in DB table
		boolean resultFlag = service.isCompanyExist("Moderna");

		System.out.println("Company Moderna is existing :" + resultFlag);

		((ConfigurableApplicationContext) factory).close();
	}
}
