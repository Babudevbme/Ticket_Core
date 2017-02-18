package com.ticket.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ticket.dao.TicketDetailtDAO;
import com.ticket.exception.ValidatorException;
import com.ticket.model.Solution;
import com.ticket.model.Transaction;
import com.ticket.validator.TicketDetailValidator;
import com.ticket.validator.UserValidator;

public class TicketDetailService {
	private static final Logger LOGGER = Logger.getLogger(UserValidator.class.getName());
	TicketDetailtDAO ticketdao = new TicketDetailtDAO();
	TicketDetailValidator ticketValidator = new TicketDetailValidator();

	public boolean createticketService(Transaction transaction) throws ValidatorException {
		try {
			ticketValidator.validateCreateTicket(transaction.getUsers().getId(), transaction.getDepartment().getName(),
					transaction.getSubject(), transaction.getDesc(), transaction.getPriority());
			ticketdao.createTicket(transaction.getUsers().getId(), transaction.getDepartment().getName(),
					transaction.getSubject(), transaction.getDesc(), transaction.getPriority());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "exception", e);
		}
		return true;
	}

	/*     */
	public Object updateByUserService(Transaction transaction) {
		try {
			ticketValidator.validateUpdateTicketByUser(transaction.getId(), transaction.getUsers().getId(),
					transaction.getSubject(), transaction.getDesc());
			return ticketdao.updateTicketByUser(transaction.getId(), transaction.getUsers().getId(),
					transaction.getSubject(), transaction.getDesc());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "exception_occur", e);
		}
		return ticketdao;

	}

	/*   */
	public Object replyTicketService(Solution solution) {
		try {
			ticketValidator.validateReplyTicket(solution.getTransaction().getId(), solution.getSolution());
			return ticketdao.replyTicket(solution.getTransaction().getId(), solution.getSolution());
		} catch (Exception e) {
			return null;
		}
	}

	/*   */
	public Object updateSolutionService(Solution solution) {
		try {
			ticketValidator.validateUpdateSolution(solution.getTransaction().getId(), solution.getEmployee().getId(),
					solution.getSolution());
			return ticketdao.updateSolutionByEmp(solution.getTransaction().getId(), solution.getEmployee().getId(),
					solution.getSolution());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "exception occur", e);
		}
		return null;
	}

	/*   */
	public Object closeTicketServer(Transaction transaction) {
		try {
			ticketValidator.validateCloseTicket(transaction.getId(), transaction.getUsers().getId());
			return ticketdao.closeTicket(transaction.getId(), transaction.getUsers().getId());

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "exception occur", e);
		}
		return ticketdao;
	}

	/*   */
	public void assignTicketService(Transaction transaction) throws ValidatorException {
		try {
			ticketValidator.validateAssignTicket(transaction.getId(), transaction.getEmployee().getId());
			ticketdao.assignTicket(transaction.getId(), transaction.getEmployee().getId());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "exception occurs", e);
		}
	}

	/*     */
	public void reassignTicketService(Transaction transaction) throws ValidatorException {
		try {
			ticketValidator.validateAssignTicket(transaction.getId(), transaction.getEmployee().getId());
			ticketdao.reassignTicket(transaction.getId(), transaction.getEmployee().getId());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "exception occurs", e);
		}
	}

	/*      */
	public List<Transaction> listByUserIdService(int userId) {
		try {
			ticketValidator.validateListByUserId(userId);
			return ticketdao.listByUserId(userId);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "exception occurs", e);
		}
		return null;
	}

	public List<Transaction> listByEmpIdService(Transaction transaction) {
		try {
			ticketValidator.validateListByEmpId(transaction.getEmployee().getId());
			return ticketdao.listByEmpId(transaction.getEmployee().getId());

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "exception occurs", e);
		}
		return null;
	}

	/*       */
	public List<Solution> solutionList(int empId) {
		try {
			ticketValidator.validateEmpId(empId);
			return ticketdao.solutionList(empId);
		} catch (ValidatorException e) {
			return null;

		}
	}

	/*    */
	public Object delete(int empId, int ticketId) {
		try {
			ticketValidator.validatedelete(empId, ticketId);
			return ticketdao.deleteTicket(empId, ticketId);
		} catch (ValidatorException e) {
			return null;
		}
	}
}
