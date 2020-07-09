package com.hotelmgmt;

import java.time.ZoneId;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelmgmt.domain.BookingDetails;
import com.hotelmgmt.domain.Customer;
import com.hotelmgmt.domain.Room;
import com.hotelmgmt.service.CustomerService;
import com.hotelmgmt.service.BookingDetailsService;
import com.hotelmgmt.service.RoomService;
import com.hotelmgmt.util.RoomType;

/**
 * HotelMgmtSystemApplication is the Starting point of Spring Boot Application
 * 
 * @author Raghava
 *
 */

@SpringBootApplication
public class HotelMgmtSystemApplication implements CommandLineRunner {

	@Autowired(required=true)
	private BookingDetailsService bookingDetailsService;

	@Autowired(required=true)
	private CustomerService customerService;
	
	@Autowired(required=true)
	private RoomService roomService;
	

	public static void main(String[] args) {
		SpringApplication.run(HotelMgmtSystemApplication.class, args);
	}

	// Below method is for Initial Data creation.
	@Override
	public void run(String... args) throws Exception {

		Calendar cal = Calendar.getInstance();

		Customer customer1 = new Customer();
		customer1.setFirstName("John");
		customer1.setLastName("Adams");
		cal.set(1982, 12, 3);
		customer1.setDateOfBirth(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		customer1.setEmail("john_test@gmail.com");
		customer1.setPassword("test123");
		customerService.saveCustomerDetails(customer1);

		Room room1 = new Room();
		room1.setRoomId(1000L);
		room1.setRoomType(RoomType.KING_BED.toString().charAt(0));
		room1.setRoomRent(Integer.valueOf(20000));
		roomService.saveRoomDetails(room1);
		
		Room room2 = new Room();
		room2.setRoomId(2000L);
		room2.setRoomType(RoomType.KING_BED.toString().charAt(0));
		room2.setRoomRent(Integer.valueOf(20000));
		roomService.saveRoomDetails(room2);
		
		Room room3 = new Room();
		room3.setRoomId(3000L);
		room3.setRoomType(RoomType.QUEEN_BED.toString().charAt(0));
		room3.setRoomRent(Integer.valueOf(67000));
		roomService.saveRoomDetails(room3);
		
		Room room4 = new Room();
		room4.setRoomId(4000L);
		room4.setRoomType(RoomType.QUEEN_BED.toString().charAt(0));
		room4.setRoomRent(Integer.valueOf(34000));
		roomService.saveRoomDetails(room4);
		

		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setCustomer(customer1);
		bookingDetails.setRoom(room1);
		cal = Calendar.getInstance();
		bookingDetails.setStartDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		cal.add(Calendar.DATE, 2);
		bookingDetails.setEndDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		bookingDetailsService.saveBookingDetails(bookingDetails);

	}

}
