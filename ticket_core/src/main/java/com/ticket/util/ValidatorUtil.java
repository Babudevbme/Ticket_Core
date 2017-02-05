package com.ticket.util;

import com.ticket.exception.ValidatorException;

public class ValidatorUtil {
	public void rejectIfNullOrEmpty(String input, String message) throws ValidatorException {
		if (input == null || "".equals(input.trim())) {
			throw new ValidatorException("Invalid " + message);
		}
	}

	public void rejectIfNegativeOrZeroOrNull(Integer input, String message) throws ValidatorException {
		if (input == null || input <= 0) {
			throw new ValidatorException("Invalid " + message);
		}
	}

	

}
