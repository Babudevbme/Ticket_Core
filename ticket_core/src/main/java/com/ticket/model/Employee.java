package com.ticket.model;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private  Department department;
	private Role role;
	private String name;
	private String emailId;
	private String password;
	private boolean active;

}
