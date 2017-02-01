package com.ticket.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Transaction {
	private int id;
	private Department department;
	private Users users;
	private Employee employee;
	private String subject;
	private String desc;
	private LocalDate date;
	private String status;

}
