package com.hotelmgmt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Entity class for storing Room data
 * 
 * @author Raghava
 *
 */
@Entity
@Table(name = "room")
@JsonRootName(value = "room")
public class Room {
	
	public Room() {
		super();
	}

	@Id
	@Column(name = "id")
	private long roomId;
	
	@Column(name = "roomtype")
	private Character roomType;
	
	@Column(name = "rent")
	private Integer roomRent;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Character getRoomType() {
		return roomType;
	}

	public void setRoomType(Character roomType) {
		this.roomType = roomType;
	}

	public Integer getRoomRent() {
		return roomRent;
	}

	public void setRoomRent(Integer roomRent) {
		this.roomRent = roomRent;
	}
	
	
	
}
