package com.hotelmgmt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmgmt.domain.Customer;
import com.hotelmgmt.exception.DataNotFoundException;
import com.hotelmgmt.service.CustomerService;

/**
 * This is the Controller class for Customer Entity
 * 
 * @author Raghava
 *
 */

@RestController
@RequestMapping("/api")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customers")
	public Iterable<Customer> getAllCustomerDetails() {
		return customerService.findAllCustomerDetails();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getSpecificCustomerDetails(@PathVariable long customerId) {

		Optional<Customer> customerInfo = customerService.findOneCustomerWithId(customerId);

		if (!customerInfo.isPresent()) {
			throw new DataNotFoundException("customerId- " + customerId);
		}

		return customerInfo.get();

	}

	@PostMapping("/customers")
	public Customer addCustomerDetails(@RequestBody Customer customerDetails) {

		customerService.saveCustomerDetails(customerDetails);

		return customerDetails;
	}

}
