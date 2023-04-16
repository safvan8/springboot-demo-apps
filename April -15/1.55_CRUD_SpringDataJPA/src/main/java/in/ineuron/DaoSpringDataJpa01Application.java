package in.ineuron;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.LocalDateType;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;
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
		// Creating ApplicationContext
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);

		// getting service bean
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		System.out.println("------------------1: Single row insertion --------------------------");
		CoronaVaccine vaccine = new CoronaVaccine(null, "covidshield", "serum", "IND", 750.0, 2);
		System.out.println(service.registerVacine(vaccine));

		System.out.println("-----2: insertion of multiple rows using single method( Batch insertion )----");
		List<CoronaVaccine> vaccines = new ArrayList<CoronaVaccine>();
		vaccines.add(new CoronaVaccine(null, "sputnik", "russie", "Russia", 567.8, 2));
		vaccines.add(new CoronaVaccine(null, "pyzer", "pyzwer", "USA", 678.8, 2));
		vaccines.add(new CoronaVaccine(null, "moderena", "moderena", "USA", 455.8, 2));

		Iterable<CoronaVaccine> listVaccines = service.registerInBatch(vaccines);

		listVaccines.forEach(vacin -> System.out.println(vacin.getRegNo()));

		System.out.println("------------------3: get count of vaccines --------------------------");
		System.out.println("Total no of vaccine count is :: " + service.getVaccineCount());

		System.out.println("---------------4: To check a record is available or not-------------");
		System.out.println("Checking for availability for the id::3 is =>  " + service.checkAvailablityByRegNo(3L));

		System.out.println("---------------5: To get all records from DB, as iterable--------------------");
		service.fetchAllDetails().forEach(System.out::println);

		System.out.println("-----6: To get Specific multiple records from DB, as iterable, by giving Primary keys----");
		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		ids.add(3L);
		Iterable<CoronaVaccine> records = service.fetchAllDetailsByID(ids);
		records.forEach(recordsPresent -> System.out.println(recordsPresent));

		System.out.println("--------7: To fetch sinlgle vaccine using id  ; 1-st way----");

		Optional<CoronaVaccine> optional = service.fecthVaccineById(3L);
		if (optional.isPresent())
			System.out.println(optional.get());
		optional.orElseThrow(() -> new IllegalArgumentException("record not found"));

		System.out.println("--------8: To fetch sinlgle vaccine using id  ; 2-nd way----");
		// else creating an Empty CoronaVaccine object
		System.out.println(service.fecthVaccineById(10L).orElse(new CoronaVaccine()));

		System.out.println("--------9: To fetch sinlgle vaccine using id  ; 3-ird way----");
		// else creating an Empty CoronaVaccine object
		System.out.println(service.fecthVaccineById(6L).orElseGet(() -> new CoronaVaccine()));

		System.out.println("--------10: To delete  a record  using id----");
		System.out.println(service.removeVaccineById(3L));

		System.out.println("--------10: To delete  a record  by passing object----");
		CoronaVaccine v = new CoronaVaccine(3L, " Can be Anything", "Only @Id needed internally",
				"all this desn't matter", 4.3, 2);
		System.out.println(service.removeVaccineByObject(v));

		System.out.println("--------11: To delete  multiple records   by passing list of id's----");
		List<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(2L);
		list.add(5L);
		System.out.println(service.removeVaccinesById(list));

		((ConfigurableApplicationContext) factory).close();
	}
}
