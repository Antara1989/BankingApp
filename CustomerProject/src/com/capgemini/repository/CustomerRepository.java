package com.capgemini.repository;

import java.util.List;

import com.capgemini.model.Customer;

public interface CustomerRepository {

	/* (non-Javadoc)
	 * @see com.capgemini.repository.CustomerRepository#findAll()
	 */
	List<Customer> findAll();

}