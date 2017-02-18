package com.ticket.service;

import javax.xml.bind.ValidationException;

import com.ticket.dao.UserDetailDAO;
import com.ticket.exception.ValidatorException;
import com.ticket.model.User;
import com.ticket.validator.UserValidator;

public class UserSevice {
	UserDetailDAO userdao = new UserDetailDAO();
	UserValidator userValidator = new UserValidator();
	public Object registerService(User user) throws ValidatorException {
		try {
			userValidator.validateUserRegister(user.getName(), user.getEmailId(), user.getPassword());
			return userdao.register(user.getName(), user.getEmailId(), user.getPassword());
		} catch (ValidatorException e)
		{
			e.printStackTrace();
		}

		return null;

	}

	public Object login(User user) throws ValidationException {

		try {
			userValidator.validateLogin(user.getEmailId(), user.getPassword());
			return userdao.login(user.getEmailId(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userdao;

	}

}
