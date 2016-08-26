package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Customer;
import com.capgemini.repository.CustomerRepository;
import com.capgemini.repository.CustomerRepositoryImpl;

public class CustomerServiceImpl implements  CustomerService {
	
	CustomerRepository customerRepository=new CustomerRepositoryImpl();
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.CustomerService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.service.CustomerService#findAll()
	 */
	
	@Override
	public List<Customer> findAll()
	{
		return customerRepository.findAll();
	}

}
