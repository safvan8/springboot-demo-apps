package in.ineuron.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long>
{
	// select * from corona_vaccine where company = ?;
	public List<CoronaVaccine> findByCompany(String company);

	// select * from corona_vaccine where company = ?;
	public List<CoronaVaccine> findByCompanyEquals(String company);

	// select * from corona_vaccine where company = ?;
	public List<CoronaVaccine> findByCompanyIs(String company);

	// select * from corona_vaccine where price < ? ;
	public List<CoronaVaccine> findByPriceLessThan(Double price);

	// select * from corona_vaccine where country in (?,?,?..) and ( startRange
	// betweeen ? and endRange ?)
	// between >= and <= ( boundry inclusive )
	public List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries, double startRange,
			double endRange);

	// select * from coronaVaccine where company not in (?);
	public List<CoronaVaccine> findByCountryNotIn(Collection<String> countries);
}
