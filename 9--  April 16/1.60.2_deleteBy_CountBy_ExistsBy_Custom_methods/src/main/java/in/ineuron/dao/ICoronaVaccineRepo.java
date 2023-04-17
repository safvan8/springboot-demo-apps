package in.ineuron.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.CoronaVaccine;

@Repository

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long>
{
	// to delete a CoronaVaccine object using name : written by following naming
	// conventions
	@Transactional
	void deleteByName(String name);

	// to count number of a specific country: custom method declaration
	long countByCountry(String country);

	// to check company name exists or not in DB table : custom method
	boolean existsByCompany(String company);
}
