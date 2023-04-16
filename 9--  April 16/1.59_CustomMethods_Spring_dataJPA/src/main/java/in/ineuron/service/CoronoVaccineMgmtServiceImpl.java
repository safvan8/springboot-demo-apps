package in.ineuron.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService
{

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccineByCompany(String company)
	{
		// to see all declared methods inside repo , impl class
		System.out.println(repo.getClass() + " " + Arrays.toString(repo.getClass().getDeclaredMethods()));

		// all the below are same operations
		List<CoronaVaccine> listEntities = repo.findByCompany(company);
		
		// finding and printing here itself
		repo.findByCompanyEquals(company).forEach(System.out::println);
		
		repo.findByCompanyIs(company).forEach(System.out::println);
		
		return listEntities;
	}

}
