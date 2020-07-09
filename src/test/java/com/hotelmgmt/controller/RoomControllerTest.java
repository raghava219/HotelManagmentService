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

import com.hotelmgmt.domain.Room;
import com.hotelmgmt.service.RoomService;
import com.hotelmgmt.testdata.HotelMgmtTestData;

/**
 * This class is Test class for RoomController
 * 
 * @author Raghava
 *
 */
public class RoomControllerTest {

	private RoomService roomServiceMock = EasyMock.createMock(RoomService.class);

	HotelMgmtTestData hotelMgmtTestData = null;

	public RoomControllerTest() {
	}

	RoomController roomController = new RoomController(roomServiceMock);

	@Before
	public void before() {
		hotelMgmtTestData = new HotelMgmtTestData();
	}

	@After
	public void after() {
	}

	@Test
	public void getAllRoomsInfo() {
		List<Room> expectedRoomDetails = hotelMgmtTestData.getRoomDetailsTestData();
		List<Room> actualRoomDetails = null;

		EasyMock.expect(roomServiceMock.findAllRoomDetails())
							.andReturn(expectedRoomDetails);
		EasyMock.replay(roomServiceMock);

		try {
			actualRoomDetails = (List<Room>) roomController.getAllRoomsInfo();
		} catch (Exception e) {
			assertFalse("Hotel Management Exception " + e.getMessage(), true);
		}

		assertEquals(actualRoomDetails, expectedRoomDetails);
	}
	
	@Test
	public void testGetSpecificRoomDetails() {
		Room expectedRoomDetail = hotelMgmtTestData.getRoomDetailsTestData().get(0);
		Room actualRoomDetail = null;

		EasyMock.expect(roomServiceMock.findOneRoomWithId(EasyMock.anyObject(Long.class)))
				.andReturn(Optional.of(expectedRoomDetail));
		EasyMock.replay(roomServiceMock);

		try {
			actualRoomDetail = roomController
					.getSpecificRoomDetails(expectedRoomDetail.getRoomId());
		} catch (Exception e) {
			assertFalse("Hotel Management Exception " + e.getMessage(), true);
		}

		assertEquals(actualRoomDetail, expectedRoomDetail);
	}

	@Test
	public void testAddRoomDetails() {

		Room expectedRoomDetail = hotelMgmtTestData.getRoomDetailsTestData().get(0);
		Room actualRoomDetail = null;

		EasyMock.expect(roomServiceMock.saveRoomDetails(EasyMock.anyObject(Room.class)))
				.andReturn(expectedRoomDetail);
		EasyMock.replay(roomServiceMock);

		try {
			actualRoomDetail = roomController.addRoomDetails(expectedRoomDetail);
		} catch (Exception e) {
			assertFalse("Hotel Management Exception " + e.getMessage(), true);
		}

		assertNotNull(actualRoomDetail);
		
	}

}
