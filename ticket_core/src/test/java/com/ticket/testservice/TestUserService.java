package com.ticket.testservice;

import com.ticket.exception.ServiceException;
import com.ticket.exception.ValidatorException;
import com.ticket.model.User;
import com.ticket.service.UserSevice;

public class TestUserService {

	public static void main(String[] args) throws ValidatorException {
			User u = new User();
		u.setName("solai");
			u.setEmailId("babudev@gmail");
			u.setPassword("babudev");

UserSevice us = new UserSevice();
System.out.println(us.loginService(u));


		}
	}


