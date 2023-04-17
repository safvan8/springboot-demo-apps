package in.ineuron.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService
{
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	@Transactional
	public void deleteVaccineByName(String name)
	{
		// calling method to be deleted
		repo.deleteByName(name);
	}

	@Override
	public long CountNumOfCountries(String country)
	{
		// calling method for counting
		return repo.countByCountry(country);
	}

	@Override
	public boolean isCompanyExist(String companyName)
	{
		// calling method
		return repo.existsByCompany(companyName);
	}

}
