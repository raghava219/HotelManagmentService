package com.hotelmgmt.repository;

import org.springframework.data.repository.CrudRepository;

import com.hotelmgmt.domain.BookingDetails;

/**
 * CRUD Repository for BookingDetails entity. 
 * 
 * @author Raghava
 *
 */
public interface BookingDetailsRepository extends CrudRepository<BookingDetails, Long> {

}
