package com.hotelmgmt.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmgmt.domain.BookingDetails;
import com.hotelmgmt.repository.BookingDetailsRepository;
import com.hotelmgmt.service.BookingDetailsService;

/**
 * This class has Service implementation for Room Entity
 * 
 * @author Raghava
 *
 */
@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {
	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;
	
	@Override
	public BookingDetails saveBookingDetails(BookingDetails bookingDetails) {
		return bookingDetailsRepository.save(bookingDetails);
	}

	@Override
	public Iterable<BookingDetails> findAllBookingDetails() {
		return bookingDetailsRepository.findAll();
	}

	@Override
	public Optional<BookingDetails> findOneBookingDetailsWithId(Long bookingId) {
		return bookingDetailsRepository.findById(bookingId);
	}

}
