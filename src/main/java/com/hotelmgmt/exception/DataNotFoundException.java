package com.hotelmgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is for throwing Data Not Found Exception with HttpStaus code 404(not found).
 * @author Raghava
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1407439533070276234L;

	public DataNotFoundException(String message) {
		super(message);
	}
	
}
