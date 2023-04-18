package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.ResultView;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long>
{	
	// select name,country from corona_vaccine where price >= :price order by :price ;
	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(Double price);

	// actually Hibernate uses ? internally instead of named parameter
}
