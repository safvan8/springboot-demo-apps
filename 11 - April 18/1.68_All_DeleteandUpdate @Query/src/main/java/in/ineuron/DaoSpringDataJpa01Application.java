package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		service.fetchVaccinesByCompany("Gamaleya Research Institute").forEach(System.out::println);

		service.fetchVaccinesByCompanies("Bharat Biotech International Limited", "Novavax Inc.").forEach(System.out::println);
		System.out.println();

		List<Object[]> names = service.fetchVaccinesByName("covidshield", "covacin");
		for (Object[] objects : names) {
			for (Object obj : objects) {
				System.out.print(obj + " ");
			}
			System.out.println();
		}

		System.out.println();

		List<String> vaccineNames = service.fetchVaccinesByPriceRange(250.0, 750.0);
		System.out.println(vaccineNames);

		
		//deletion
		System.out.println("No of records updated is :: " + service.modifyingPriceByCountry(800.0, "USA"));
		System.out.println("No of records deleted is :: " + service.removeVacinesByPrice(750.0, 1000.0));
		((ConfigurableApplicationContext) factory).close();
	}
}
