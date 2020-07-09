package com.hotelmgmt.service;

import java.util.Optional;

import com.hotelmgmt.domain.Customer;

/**
 * This Service interface has methods for Customer Entity
 * 
 * @author Raghava
 *
 */
public interface CustomerService {
	
	Customer saveCustomerDetails(Customer customer);
	
	Iterable<Customer> findAllCustomerDetails();
	
	Optional<Customer> findOneCustomerWithId(Long customerId);

}
