package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Customer;
import in.ineuron.dao.ICustomerRepo;

@Service(value = "serviceLayer")
public class CustomerServiceImpl implements ICustomerService
{

	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(Customer customer)
	{
		// saving customer
		Customer savedObj = repo.save(customer);

		return "Customer Record inserted with id:" + savedObj.getCid();
	}

	@Override
	public List<Customer> displayAllCustomersInfo()
	{
		Iterable<Customer> allCustomers = repo.findAll();

		return (List<Customer>) allCustomers;
	}

}
