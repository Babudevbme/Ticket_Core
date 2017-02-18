package com.ticket.exception;
/**
 * hello
 * @author Babudev
 *
 */
public class PersistenceException extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	private PersistenceException(String message) {
		super(message);
	}

}
