package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService
{
	/*
	 * ICoronaVaccineRepo instance referenced by the repo field is typically created
	 * and injected by an Inversion of Control (IoC) container at runtime as a proxy
	 * implementation. The exact behavior depends on the specific IoC container
	 * being used, but in general, the container will create a dynamic proxy object
	 * that implements the ICoronaVaccineRepo interface and delegates method calls
	 * to the actual implementation.
	 * 
	 * This allows the IoC container to manage the lifetime and dependencies of the
	 * ICoronaVaccineRepo object, as well as potentially providing additional
	 * features such as caching or transaction management. The use of IoC and
	 * dependency injection can help to make the code more modular, testable, and
	 * maintainable.
	 */
	@Autowired
	private ICoronaVaccineRepo repo;

	/**
	 * Retrieves all the records from the CoronaVaccine entity and sorts them based
	 * on the given properties and sort order.
	 *
	 * @param asc        Whether to sort in ascending order or not.
	 * @param properties The properties to sort on.
	 * @return An iterable containing the sorted records.
	 */
	@Override
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties)
	{
		System.out.println("Proxy class implementation name is :: " + repo.getClass().getName());

		// Creating Sort object based on given input
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<CoronaVaccine> listEntities = repo.findAll(sort);
		return listEntities;
	}

	/**
	 * Retrieves a specific page of records from the CoronaVaccine entity based on
	 * the given page number, page size, properties to sort on, and sort order.
	 *
	 * @param pageNo     The page number to retrieve (starting from 0).
	 * @param pageSize   The number of records to retrieve per each page.
	 * @param asc        Whether to sort in ascending order or not.
	 * @param properties The properties to sort on.
	 * @return An iterable containing the records on the specified page.
	 */
	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties)
	{
		/*
		 * creating a Pageable object using PageRequest.of() method. Pageable is an
		 * interface that represents a request for a pageable set of results. It
		 * provides the requested page, the number of records per page, and the sort
		 * order.
		 */
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc ? Direction.ASC : Direction.DESC, properties);
		
		Page<CoronaVaccine> page = repo.findAll(pageable);
		return page.getContent();
	}

	/**
	 * Retrieves all the records from the CoronaVaccine entity using pagination,
	 * with each page having the given page size.
	 * 
	 * user-defined method using available method inside interface PagingAndSortingRepository<T,ID>
	 *
	 * @param pageSize The number of records to retrieve per page.
	 */
	@Override
	public void fetchDetailsByPagination(int pageSize)
	{
		// total record count in Database
		long count = repo.count();// total = 7

		// pageSize = no.of records can be displayed on one page = 3

		// deciding pagesCount
		long pagesCount = count / pageSize;// pagesCount = 7/3 = 2

		// if we got reminder to include that records also we need to increase page
		// count by one
		pagesCount = count % pageSize == 0 ? pagesCount : ++pagesCount; // pagesCount = 3

		for (int i = 0; i < pagesCount; i++)
		{
			// loop running from 0,1,2
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page = repo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("-------------------" + (i + 1) + " of :: " + page.getTotalPages());
		}
	}
}
