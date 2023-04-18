package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICoronaVaccineRepo;
import in.ineuron.type.ResultView;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService
{
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<ResultView> searchVaccineByStartPrice(Double price)
	{
		System.out.println("Repository Inteface proxy class is :: " + repo.getClass().getName());

		// calling method, implementation will be given by proxy class
		return repo.findByPriceGreaterThanEqualOrderByPrice(price);
	}
}
