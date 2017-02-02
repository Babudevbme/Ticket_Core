package com.ticket.model;

import lombok.Data;

@Data
public class Users {
	private int id;
	private String name;
	private String emailId;
	private String password;
	private boolean active;
	

}
