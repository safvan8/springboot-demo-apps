package in.ineuron;

import javax.persistence.EntityNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDataJpa01Application
{
	public static void main(String[] args)
	{
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		CoronaVaccine cov = new CoronaVaccine();
		cov.setCompany("serum");
		cov.setName("covaxin");
		// only company and vaccine name is added

		// false -> desc
		service.searchVaccinesByGivenData(cov, false, "price").forEach(System.out::println);

		System.out.println("******************************************************************");

		// if object is not found in database when checked using passed id , then we
		// will getjavax.persistence.EntityNotFoundException, no way to remove this Exception message
		try
		{
			CoronaVaccine vaccine = service.getVaccineById(20L);
			System.out.println("Vaccine details are :: " + vaccine);
		} catch (EntityNotFoundException e)
		{
			System.out.println("Record not available for the given id");
		} catch (Exception e)
		{
			// handle other exceptions
		}

		((ConfigurableApplicationContext) factory).close();
	}
}
