package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService
{
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder, String... properties)
	{

        System.out.println("Proxy class is :: " + repo.getClass().getName());

        // Creating an Example object using the provided CoronaVaccine object
        Example<CoronaVaccine> example = Example.of(vaccine);
        
        Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, properties);

        List<CoronaVaccine> listEntites = repo.findAll(example, sort);

        // Returning the list of entities
        return listEntites;
	}

	@Override
	public CoronaVaccine getVaccineById(Long regNo)
	{

		CoronaVaccine vaccine = repo.getById(regNo);
		return vaccine;
	}

}
