package in.ineuron.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
		return repo.searchVaccinesByCompany(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompanies(String comp1, String comp2) {
		return repo.searchVaccinesByComapnies(comp1, comp2);
	}

	@Override
	public List<String> fetchVaccinesByPriceRange(double min, double max) {
		return repo.searchVaccinesByPriceRange(min, max);
	}

	@Override
	public List<Object[]> fetchVaccinesByName(String name1, String name2) {
		return repo.searchVaccinesByName(name1, name2);
	}

	@Override
	@Transactional
	public int modifyingPriceByCountry(double newPrice, String country) {
		return repo.updatePriceByCountry(newPrice, country);
	}

	@Override
	public int removeVacinesByPrice(double startPrice, double endPrice) {
		return repo.deleteVaccineByPrice(startPrice, endPrice);
	}
	
	

}
