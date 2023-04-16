package in.ineuron.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends PagingAndSortingRepository<CoronaVaccine, Long>
{
	/**
	 * ICoronaVaccineRepo --> pojo class name
	 * Long               --> Primary key Data type 
	 * 
	 * The "ICoronaVaccineRepo" interface uses generics to specify the type of
	 * entity it will work with (in this case, "CoronaVaccine") and the type of the
	 * primary key field of that entity (in this case, "Long").
	 * 
	 * Overall, this code is defining a Spring Data JPA repository for the
	 * "CoronaVaccine" entity, which can be used to perform CRUD (create, read,
	 * update, delete) operations on the data in a database.
	 */

	/**
	 * PagingAndSortingRepository interface extends the CrudRepository interface,
	 * which provides basic CRUD operations such as save(), findById(),
	 * deleteById(), etc.
	 * 
	 * So, we can use the same interface to perform both CRUD and
	 * pagination/sorting operations on the "CoronaVaccine" entity.
	 */
}
