package com.ticket.testservice;

import com.ticket.exception.ServiceException;
import com.ticket.exception.ValidatorException;
import com.ticket.model.User;
import com.ticket.service.UserSevice;

public class TestUserService {

	public static void main(String[] args) throws ValidatorException, ServiceException {
			User u = new User();
		u.setName("yash");
			u.setEmailId("babudev95@gmail");
			u.setPassword("babudev787");

UserSevice us = new UserSevice();
//System.out.println(us.loginService(u));
System.out.println(us.registerService(u));


		}
	}


