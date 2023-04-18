package in.ineuron;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;
import in.ineuron.type.ResultView;

@SpringBootApplication
public class DaoSpringDataJpa01Application
{

	public static void main(String[] args)
	{
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		// to get name and country of vaccine which have price >= 10.0
		List<ResultView> listVaccines = service.searchVaccineByStartPrice(10.0);

		System.out.println("Name   and country of vaccines with >= 10.0 \n--------------------");
		listVaccines.forEach(vaccine ->
		{

			System.out.println(vaccine.getName() + " " + vaccine.getCountry());
		});

		System.out.println("==========All declared methods from proxy class========");

		ResultView oneRow = listVaccines.get(0);
		System.out.println(Arrays.toString(oneRow.getClass().getDeclaredMethods()));

		((ConfigurableApplicationContext) factory).close();
	}
}
