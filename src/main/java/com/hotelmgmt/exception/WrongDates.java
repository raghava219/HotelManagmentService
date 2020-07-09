package com.hotelmgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is for throwing Reservation Dates correction with HttpStaus code 400(Bad Request).
 * @author Raghava
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongDates extends RuntimeException {

	private static final long serialVersionUID = -403834004316155714L;

	public WrongDates(String message) {
		super(message);
	}
	
}
