package com.hotelmgmt.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hotelmgmt.domain.Customer;
import com.hotelmgmt.domain.Room;
import com.hotelmgmt.service.CustomerService;
import com.hotelmgmt.testdata.HotelMgmtTestData;

/**
 * This is the Test class for CustomerController
 * 
 * @author Raghava
 *
 */
public class CustomerControllerTest {

	private CustomerService customerServiceMock = EasyMock.createMock(CustomerService.class);

	HotelMgmtTestData hotelMgmtTestData = null;

	public CustomerControllerTest() {
	}

	CustomerController customerController = new CustomerController(customerServiceMock);

	@Before
	public void before() {
		hotelMgmtTestData = new HotelMgmtTestData();
	}

	@After
	public void after() {
	}

	@Test
	public void getAllRoomsInfo() {
		List<Customer> expectedCustomerDetails = hotelMgmtTestData.getCustomerDetailsTestData();
		List<Customer> actualCustomerDetails = null;

		EasyMock.expect(customerServiceMock.findAllCustomerDetails())
							.andReturn(expectedCustomerDetails);
		EasyMock.replay(customerServiceMock);

		try {
			actualCustomerDetails = (List<Customer>) customerController.getAllCustomerDetails();
		} catch (Exception e) {
			assertFalse("Hotel Management Exception " + e.getMessage(), true);
		}

		assertEquals(actualCustomerDetails, expectedCustomerDetails);
	}
	
	@Test
	public void testGetSpecificCustomerDetails() {
		Customer expectedCustomerDetail = hotelMgmtTestData.getCustomerDetailsTestData().get(0);
		Customer actualCustomerDetail = null;

		EasyMock.expect(customerServiceMock.findOneCustomerWithId(EasyMock.anyObject(Long.class)))
				.andReturn(Optional.of(expectedCustomerDetail));
		EasyMock.replay(customerServiceMock);

		try {
			actualCustomerDetail = customerController
					.getSpecificCustomerDetails(expectedCustomerDetail.getCustomerId());
		} catch (Exception e) {
			assertFalse("Hotel Management Exception " + e.getMessage(), true);
		}

		assertEquals(actualCustomerDetail, expectedCustomerDetail);
	}

	@Test
	public void testAddCustomerDetails() {

		Customer expectedCustomerDetail = hotelMgmtTestData.getCustomerDetailsTestData().get(0);
		Customer actualCustomerDetail = null;

		EasyMock.expect(customerServiceMock.saveCustomerDetails(EasyMock.anyObject(Customer.class)))
				.andReturn(expectedCustomerDetail);
		EasyMock.replay(customerServiceMock);

		try {
			actualCustomerDetail = customerController.addCustomerDetails(expectedCustomerDetail);
		} catch (Exception e) {
			assertFalse("Hotel Management Exception " + e.getMessage(), true);
		}

		assertNotNull(actualCustomerDetail);
		
	}

}
