package com.hotelmgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is for throwing Rooms Not Available Exception with HttpStaus code 400(Bad Request).
 * @author Raghava
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoomsNotAvailable extends RuntimeException {

	private static final long serialVersionUID = -7105993223522733624L;

	public RoomsNotAvailable(String message) {
		super(message);
	}
	
}
