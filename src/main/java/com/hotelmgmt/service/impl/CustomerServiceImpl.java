package com.hotelmgmt.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmgmt.domain.Customer;
import com.hotelmgmt.repository.CustomerRepository;
import com.hotelmgmt.service.CustomerService;

/**
 * This class has service implementations for Customer Entity
 * 
 * @author ragha
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomerDetails(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Iterable<Customer> findAllCustomerDetails() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findOneCustomerWithId(Long customerId) {
		return customerRepository.findById(customerId);
	}

}
