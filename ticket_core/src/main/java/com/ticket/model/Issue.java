package com.ticket.model;

import lombok.Data;

@Data
public class Issue {
	private int id;
	private Employee employee;
	private  Transaction transaction;
	private String solution;

}
