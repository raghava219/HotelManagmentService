package com.hotelmgmt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmgmt.domain.Room;
import com.hotelmgmt.exception.DataNotFoundException;
import com.hotelmgmt.service.RoomService;

/**
 * This is controller class for Room Entity
 * 
 * @author Raghava
 *
 */
@RestController
@RequestMapping("/api")
public class RoomController {

	private RoomService roomService;
	
	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("/rooms")
	public Iterable<Room> getAllRoomsInfo() {
		return roomService.findAllRoomDetails();
	}
	
	@GetMapping("/rooms/{roomId}")
	public Room getSpecificRoomDetails(@PathVariable long roomId) {
		
		Optional<Room> roomInfo = roomService.findOneRoomWithId(roomId);

		if (!roomInfo.isPresent()) {
			throw new DataNotFoundException("roomId- " + roomId);
		}

		return roomInfo.get();
	}
	
	@PostMapping("/rooms")
	public Room addRoomDetails(@RequestBody Room roomDetails) {

		roomService.saveRoomDetails(roomDetails);
		
		return roomDetails;
	}
	
	
}
