package com.ticket.dao;

import java.util.List;

import com.ticket.model.Solution;
import com.ticket.model.Transaction;

public interface ITicketDetailDAO {

	/* create ticket */
	void createTicket(int userId, String deptName, String subject, String description, String priority);

	Object updateTicketByUser(int id, int userId, String subject, String description);

	Object replyTicket(int ticketId, String solution) throws Exception;

	Object updateSolutionByEmp(int ticketId, int empId, String solution);

	Object closeTicket(int id, int userId);

	void assignTicket(int ticketId, int employeeId);

	void reassignTicket(int ticketId, int employeeId);

	List<Transaction> listByUserId(int userId);

	List<Transaction> listByEmpId(int empId);

	int deleteTicket(int empId, int ticketId);

	List<Solution> solutionList(int empId);

}