package com.ticket.testservice;

import com.ticket.exception.ServiceException;
import com.ticket.model.User;
import com.ticket.service.UserSevice;

public class TestService {

	public static void main(String[] args) throws ServiceException {
			User u = new User();
			u.setName("ghgh");
			u.setEmailId("babu");;
			u.setPassword("sfv");

UserSevice us = new UserSevice();
us.saveService(u);
		}
	}


