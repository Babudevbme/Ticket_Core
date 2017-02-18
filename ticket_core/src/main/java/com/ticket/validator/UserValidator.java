package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.util.ValidatorUtil;

public class UserValidator{

	ValidatorUtil validatorUtil = new ValidatorUtil();
	
	public void  validateUserRegister(String name ,String email,String password) throws ValidatorException
	{
validatorUtil.rejectIfNullOrEmpty(name, "name");
validatorUtil.rejectIfNullOrEmpty(email, "email_id");
validatorUtil.rejectIfNullOrEmpty(password, "password");

			
	}
	public void validateLogin(String email,String password)throws ValidatorException{
		validatorUtil.rejectIfNullOrEmpty(email, "email_id");
		validatorUtil.rejectIfNullOrEmpty(password, "password");
		
	}
	

	}


