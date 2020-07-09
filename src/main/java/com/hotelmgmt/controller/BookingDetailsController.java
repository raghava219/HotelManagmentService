package com.hotelmgmt.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hotelmgmt.domain.BookingDetails;
import com.hotelmgmt.domain.Room;
import com.hotelmgmt.exception.DataNotFoundException;
import com.hotelmgmt.exception.RoomsNotAvailable;
import com.hotelmgmt.exception.WrongDates;
import com.hotelmgmt.service.BookingDetailsService;
import com.hotelmgmt.service.CustomerService;
import com.hotelmgmt.service.RoomService;

/**
 * This is controller class from BookingDetails Entity
 * 
 * @author Raghava
 *
 */
@RestController
@RequestMapping("/api")
public class BookingDetailsController {

	private BookingDetailsService bookingDetailsService;

	private CustomerService customerService;
	
	private RoomService roomService;
	
	public BookingDetailsService getBookingDetailsService() {
		return bookingDetailsService;
	}

	@Autowired(required=true)
	public void setBookingDetailsService(BookingDetailsService bookingDetailsService) {
		this.bookingDetailsService = bookingDetailsService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	@Autowired(required=true)
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public RoomService getRoomService() {
		return roomService;
	}

	@Autowired(required=true)
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public BookingDetailsController() {
	}

	@GetMapping("/bookings")
	public Iterable<BookingDetails> getAllBookingDetails() {
		return bookingDetailsService.findAllBookingDetails();
	}
	
	@GetMapping("/bookings/{bookingId}")
	public BookingDetails getSpecificBookingDetails(@PathVariable long bookingId) {
		
		Optional<BookingDetails> bookingDetails = bookingDetailsService
														.findOneBookingDetailsWithId(bookingId);
		if (!bookingDetails.isPresent()) {
			throw new DataNotFoundException("bookingId- "+bookingId);
		} 
				
		return bookingDetails.get();
	}

	@PostMapping("/bookings")
	public ResponseEntity<Object> addBookingDetails(@RequestBody BookingDetails bookingDetails) {

		boolean wrongDates = this.validateBookingDates(bookingDetails);
		long roomId = bookingDetails.getRoom().getRoomId();
		
		if (wrongDates) {
			throw new WrongDates("Correct the Reservation Dates");
		}
		
		Optional<Room> availabelRoom = roomService.findOneRoomWithId(roomId);
		
		if (!availabelRoom.isPresent()) {
			throw new RoomsNotAvailable("This Room with Id "+roomId+" not available");
		}

		customerService.saveCustomerDetails(bookingDetails.getCustomer());

		BookingDetails savedBookingDetails = bookingDetailsService.saveBookingDetails(bookingDetails);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
				.buildAndExpand(savedBookingDetails.getBookingId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	private boolean validateBookingDates(BookingDetails bookingDetails) {

		boolean wrongDates = false;
		
		if (bookingDetails.getEndDate().isBefore(bookingDetails.getStartDate())) {
			wrongDates = true;
		}
		
		return wrongDates;
	}

}
