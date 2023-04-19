package in.ineuron.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.Customer;

@Repository
public interface ICustomerRepo extends PagingAndSortingRepository<Customer, Integer>
{

}
