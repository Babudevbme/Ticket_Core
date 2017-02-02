package com.ticket.model;

import lombok.Data;

@Data
public class Issues {
	private int id;
	private  Transaction transaction;
	private String solution;

}
