package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.View;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long>
{
	public <T extends View> List<T> findByCompanyOrderByCompanyDesc(String company, Class<T> clazz);
	
	/**
	 * The <T extends View> part of the method signature is called a type parameter.
	 * It indicates that the T type is a generic type that must extend the View
	 * interface. This means that the caller can pass in any projection interface
	 * that extends the View interface, and the method will return a list of objects
	 * that match the specified projection. this ' T ' restriction is applicable
	 * till method level
	 * Ie,
	 * the <T extends View> is applicable for the Class<T> parameter as well. This
	 * means that the clazz parameter should be a Class object that extends or
	 * implements the View interface.
	 * 
	 */
}
