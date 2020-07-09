package com.hotelmgmt.testdata;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hotelmgmt.domain.BookingDetails;
import com.hotelmgmt.domain.Customer;
import com.hotelmgmt.domain.Room;
import com.hotelmgmt.util.RoomType;

public class HotelMgmtTestData {

	public List<BookingDetails> getAllBookingDetails() {

		List<BookingDetails> bookingDetailsList = new ArrayList<>();
		List<Customer> customerList = this.getCustomerDetailsTestData();
		List<Room> roomList = this.getRoomDetailsTestData();
		Calendar cal = Calendar.getInstance();

		BookingDetails bookingDetails1 = new BookingDetails();
		bookingDetails1.setCustomer(customerList.get(0));
		bookingDetails1.setRoom(roomList.get(0));
		bookingDetails1.setStartDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		cal.add(Calendar.DATE, 2);
		bookingDetails1.setEndDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		bookingDetailsList.add(bookingDetails1);

		BookingDetails bookingDetails2 = new BookingDetails();
		bookingDetails2.setCustomer(customerList.get(1));
		bookingDetails2.setRoom(roomList.get(1));
		bookingDetails2.setStartDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		cal.add(Calendar.DATE, 3);
		bookingDetails2.setEndDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		bookingDetailsList.add(bookingDetails2);

		BookingDetails bookingDetails3 = new BookingDetails();
		bookingDetails3.setCustomer(customerList.get(2));
		bookingDetails3.setRoom(roomList.get(2));
		bookingDetails3.setStartDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		cal.add(Calendar.DATE, 4);
		bookingDetails3.setEndDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		bookingDetailsList.add(bookingDetails3);

		return bookingDetailsList;

	}

	public List<Customer> getCustomerDetailsTestData() {

		List<Customer> customerList = new ArrayList<>();

		Calendar cal = Calendar.getInstance();

		Customer customer1 = new Customer();
		customer1.setCustomerId(100);
		customer1.setFirstName("John");
		customer1.setLastName("Adams");
		cal.set(1982, 12, 3);
		customer1.setDateOfBirth(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		customer1.setEmail("john_test@gmail.com");
		customer1.setPassword("test123");

		customerList.add(customer1);

		Customer customer2 = new Customer();
		customer1.setCustomerId(200);
		customer2.setFirstName("Haide");
		customer2.setLastName("Jona");
		cal.set(2000, 12, 3);
		customer2.setDateOfBirth(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		customer2.setEmail("jona_heigd@gmail.com");
		customer2.setPassword("test12312345");

		customerList.add(customer2);

		Customer customer3 = new Customer();
		customer1.setCustomerId(300);
		customer3.setFirstName("Haide");
		customer3.setLastName("Jona");
		cal.set(2000, 12, 3);
		customer3.setDateOfBirth(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		customer3.setEmail("jona_heigd@gmail.com");
		customer3.setPassword("test12312345");

		customerList.add(customer3);

		return customerList;
	}

	public List<Room> getRoomDetailsTestData() {

		List<Room> roomList = new ArrayList<Room>();

		Room room1 = new Room();
		room1.setRoomId(100L);
		room1.setRoomType(RoomType.KING_BED.toString().charAt(0));
		room1.setRoomRent(Integer.valueOf(20000));
		roomList.add(room1);

		Room room2 = new Room();
		room2.setRoomId(200L);
		room2.setRoomType(RoomType.QUEEN_BED.toString().charAt(0));
		room2.setRoomRent(Integer.valueOf(89000));
		roomList.add(room2);

		Room room3 = new Room();
		room2.setRoomId(300L);
		room2.setRoomType(RoomType.QUEEN_BED.toString().charAt(0));
		room2.setRoomRent(Integer.valueOf(89000));
		roomList.add(room2);

		return roomList;
	}

	public BookingDetails getSingleBookingDetails() {
		Calendar cal = Calendar.getInstance();

		Customer newCustomer = new Customer();
		newCustomer.setCustomerId(100);
		newCustomer.setFirstName("John");
		newCustomer.setLastName("Adams");
		cal.set(1982, 12, 3);
		newCustomer.setDateOfBirth(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		newCustomer.setEmail("john_test@gmail.com");
		newCustomer.setPassword("test123");

		Room newRoom = new Room();
		newRoom.setRoomId(300L);
		newRoom.setRoomType(RoomType.QUEEN_BED.toString().charAt(0));
		newRoom.setRoomRent(Integer.valueOf(89000));

		BookingDetails newBooking = new BookingDetails();
		newBooking.setCustomer(newCustomer);
		newBooking.setRoom(newRoom);
		newBooking.setStartDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		cal.add(Calendar.DATE, 2);
		newBooking.setEndDate(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

		return newBooking;
	}

}
