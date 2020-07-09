package com.hotelmgmt.service;

import java.util.Optional;

import com.hotelmgmt.domain.Room;

/**
 * This Service interface has methods for Room Entity
 * 
 * @author Raghava
 *
 */
public interface RoomService {
	
	Room saveRoomDetails(Room room);
	
	Iterable<Room> findAllRoomDetails();
	
	Optional<Room> findOneRoomWithId(Long roomId);

	
}
