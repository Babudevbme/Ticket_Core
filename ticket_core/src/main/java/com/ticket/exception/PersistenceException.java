package com.ticket.exception;

public class PersistenceException extends Exception  {

	private PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	private PersistenceException(String message) {
		super(message);
	}

}
