package com.hotelmgmt.service;

import java.util.Optional;

import com.hotelmgmt.domain.BookingDetails;

/**
 * This Service interface has methods for RoomBooking Entity
 * 
 * @author Raghava
 *
 */
public interface BookingDetailsService {

	BookingDetails saveBookingDetails(BookingDetails bookingDetails);

	Iterable<BookingDetails> findAllBookingDetails();
	
	Optional<BookingDetails> findOneBookingDetailsWithId(Long bookingId);
	
}
