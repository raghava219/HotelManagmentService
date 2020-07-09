package com.hotelmgmt.repository;

import org.springframework.data.repository.CrudRepository;

import com.hotelmgmt.domain.Room;

/**
 * CRUD repository for Room entity.
 * 
 * @author Raghava
 *
 */
public interface RoomRepository extends CrudRepository<Room, Long> {

}
