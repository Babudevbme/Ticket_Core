package com.ticket.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ticket.dao.UserDetailDAO;
import com.ticket.exception.ServiceException;
import com.ticket.exception.ValidatorException;
import com.ticket.model.User;
import com.ticket.validator.UserValidator;

public class UserSevice {
	private static final Logger LOGGER = Logger.getLogger(UserValidator.class.getName());
    UserDetailDAO ud = new UserDetailDAO();
	UserValidator uv = new UserValidator();


	public boolean registerService(User u) throws ServiceException {
		try {
			uv.validateUserRegister(u.getName(), u.getEmailId(), u.getPassword());
            ud.register(u.getName(), u.getEmailId(),u.getPassword());
		} catch (Exception e) {

			LOGGER.log(Level.SEVERE,"exception occur",e);
		}
		return "true" != null;
	}
	public String loginService(User u) throws ValidatorException
	{         
	try{
		uv.validateLogin(u.getEmailId(),u.getPassword());
	}
	catch (ValidatorException e){
		LOGGER.log(Level.SEVERE,"exception occur",e);
	}
	   return ud.login(u.getEmailId(),u.getPassword()); 

	

}
		
	}
		

