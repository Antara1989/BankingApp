package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Customer;

public interface CustomerService {

	/* (non-Javadoc)
	 * @see com.capgemini.service.CustomerService#findAll()
	 */
	List<Customer> findAll();

}