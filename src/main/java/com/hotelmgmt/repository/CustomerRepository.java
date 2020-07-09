package com.hotelmgmt.repository;

import org.springframework.data.repository.CrudRepository;

import com.hotelmgmt.domain.Customer;

/**
 * CRUD Repository for Customer Entity.
 * 
 * @author Raghava
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
