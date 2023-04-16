package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long>
{

	// CoronaVaccine --> POjo class Name
	// Long --> Primary key data type of pojo class
	
	/**
	 * in the case of this application we are performing only CRUD operations.
	 * So no need to write method names inside this interface ( because all CRUD operations have 
	 * pre-defined methods available )
	 * 
	 * if we have any custom methods, then we need to declare methods as per Naming convention by 
	 * Spring Data team . 
	 */
}
