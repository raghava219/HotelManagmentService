package com.hotelmgmt.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmgmt.domain.Room;
import com.hotelmgmt.repository.RoomRepository;
import com.hotelmgmt.service.RoomService;

/**
 * This class has service implementations for Room Entity
 * 
 * @author Raghava
 *
 */
@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room saveRoomDetails(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public Iterable<Room> findAllRoomDetails() {
		return roomRepository.findAll();
	}

	@Override
	public Optional<Room> findOneRoomWithId(Long roomId) {
		return roomRepository.findById(roomId);
	}

}
