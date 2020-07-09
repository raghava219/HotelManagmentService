package com.hotelmgmt.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hotelmgmt.domain.BookingDetails;
import com.hotelmgmt.domain.Customer;
import com.hotelmgmt.domain.Room;
import com.hotelmgmt.service.BookingDetailsService;
import com.hotelmgmt.service.CustomerService;
import com.hotelmgmt.service.RoomService;
import com.hotelmgmt.testdata.HotelMgmtTestData;

/**
 * This is the Test class for BookingDetailsController
 * 
 * @author Raghava
 *
 */
public class BookingDetailsControllerTest {

	private BookingDetailsService bookingDetailsServiceMock = EasyMock
																.createMock(BookingDetailsService.class);

	private CustomerService customerServiceMock = EasyMock.createMock(CustomerService.class);
	
	private RoomService roomServiceMock = EasyMock.createMock(RoomService.class);
	
	HotelMgmtTestData hotelMgmtTestData = null;
	
	public BookingDetailsControllerTest() {
	}
	
	BookingDetailsController bookingDetailsController = new BookingDetailsController();
	
	@Before
	public void before() {
		bookingDetailsController.setBookingDetailsService(bookingDetailsServiceMock);
		bookingDetailsController.setCustomerService(customerServiceMock);
		bookingDetailsController.setRoomService(roomServiceMock);
		hotelMgmtTestData = new HotelMgmtTestData();
	}

	@After
	public void after() {
	}
	
	@Test
	public void testGetAllBookingDetails() {
		
		List<BookingDetails> expectedBookingDetails = hotelMgmtTestData.getAllBookingDetails();
		List<BookingDetails> actualBookingDetails = null;
		
		EasyMock.expect(bookingDetailsServiceMock.findAllBookingDetails()).andReturn(expectedBookingDetails);
		EasyMock.replay(bookingDetailsServiceMock);
		
		try {
			actualBookingDetails = (List<BookingDetails>) bookingDetailsController.getAllBookingDetails();
		} catch (Exception e) {
			assertFalse("Hotel Management Exception "+e.getMessage(), true);
		}
		
		assertEquals(expectedBookingDetails.size(), actualBookingDetails.size());
	}
	
	@Test
	public void testGetSpecificBookingDetails() {
		BookingDetails expectedBookingDetail = hotelMgmtTestData.getSingleBookingDetails();
		BookingDetails actualBookingDetail = null;
		
		EasyMock.expect(bookingDetailsServiceMock.findOneBookingDetailsWithId(EasyMock.anyObject(Long.class)))
			.andReturn(Optional.of(expectedBookingDetail));
		EasyMock.replay(bookingDetailsServiceMock);
		
		try {
			actualBookingDetail = bookingDetailsController
										.getSpecificBookingDetails(expectedBookingDetail.getBookingId());
		} catch (Exception e) {
			assertFalse("Hotel Management Exception "+e.getMessage(), true);
		}
		
		assertEquals(expectedBookingDetail, actualBookingDetail);
	}
	
	@Test
	public void testAddBookingDetails() {
		
		ResponseEntity<Object> responseEntity = null;
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Customer singleCustomer = hotelMgmtTestData.getCustomerDetailsTestData().get(0);
        Room singleRoom = hotelMgmtTestData.getRoomDetailsTestData().get(0);
		BookingDetails singleBooking = hotelMgmtTestData.getAllBookingDetails().get(0);
        
		EasyMock.expect(customerServiceMock.saveCustomerDetails(EasyMock.anyObject())).andReturn(singleCustomer);
		EasyMock.replay(customerServiceMock);
		
		EasyMock.expect(roomServiceMock.findOneRoomWithId(EasyMock.anyObject(Long.class)))
											.andReturn(Optional.of(singleRoom));
		EasyMock.replay(roomServiceMock);
		
		EasyMock.expect(bookingDetailsServiceMock.saveBookingDetails(EasyMock.anyObject(BookingDetails.class)))
											.andReturn(singleBooking);
		EasyMock.replay(bookingDetailsServiceMock);
		
		BookingDetails newBookingDetails = hotelMgmtTestData.getSingleBookingDetails();
		
		try {
			responseEntity = bookingDetailsController.addBookingDetails(newBookingDetails);
		} catch (Exception e) {
			assertFalse("Hotel Management Exception "+e.getMessage(), true);
		}
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		
	}

		
	
}
