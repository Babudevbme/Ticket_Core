package com.ticket.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ticket.dao.UserDAO;
import com.ticket.exception.ServiceException;
import com.ticket.model.User;
import com.ticket.validator.UserValidator;

public class UserSevice {
	private static final Logger LOGGER = Logger.getLogger(UserValidator.class.getName());

	public void saveService(User u) throws ServiceException {
		try {
			UserValidator uv = new UserValidator();
			uv.validateSave(u.getName());
			uv.validateSave(u.getEmailId());
			uv.validateSave(u.getPassword());
			UserDAO ud = new UserDAO();
			ud.save(u);
		} catch (Exception e) {

			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("INVALID PARAMETER VALUES");
			throw new ServiceException("CANNOT INSERT INTO TABLE", e);
		}
	}

}
