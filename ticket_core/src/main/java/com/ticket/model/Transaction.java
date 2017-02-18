package com.ticket.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Transaction {
	private int id;
	private Department department;
	private User users;
	private Employee employee;
	private String assignTo;
	private String subject;
	private String desc;
	private LocalDateTime timeStamp;
	private String status;
	private String priority;

}
