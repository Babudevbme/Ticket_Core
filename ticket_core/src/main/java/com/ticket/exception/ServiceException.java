package com.ticket.exception;

public class ServiceException extends Exception {

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	private ServiceException(String message) {
		super(message);
	}
	
	


}
