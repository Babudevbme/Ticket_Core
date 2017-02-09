package com.ticket.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ticket.dao.TicketDetailtDAO;
import com.ticket.exception.ValidatorException;
import com.ticket.model.Issue;
import com.ticket.model.Transaction;
import com.ticket.validator.TicketDetailValidator;
import com.ticket.validator.UserValidator;

public class TicketDetailService {
	private static final Logger LOGGER = Logger.getLogger(UserValidator.class.getName());
	TicketDetailtDAO dao=new TicketDetailtDAO();
	TicketDetailValidator tv=new TicketDetailValidator();
	
	public boolean createticketService(Transaction t) throws ValidatorException{
		try{
			tv.validateCreateTicket(t.getUsers().getId(),t.getDepartment().getName() ,t.getSubject(),t.getDesc(),t.getPriority());
		dao.createTicket(t.getUsers().getId(),t.getDepartment().getName() ,t.getSubject(),t.getDesc(),t.getPriority());
		}
		catch (Exception e){
			LOGGER.log(Level.SEVERE,"exception",e);
		}
		return true;
	}
	/*     */
	public void updateByUserService(Transaction t){
		try{
			tv.validateUpdateTicketByUser(t.getId(), t.getUsers().getId(), t.getSubject(), t.getDesc());
			dao.updateTicketByUser(t.getId(), t.getUsers().getId(), t.getSubject(), t.getDesc());
		}
		catch(Exception e){LOGGER.log(Level.SEVERE,"exception_occur",e);}
		
	}
	/*   */
	public void replyTicketService(Issue i){
		try{
			tv.validateReplyTicket(i.getTransaction().getId(),i.getSolution());
			dao.replyTicket(i.getTransaction().getId(),i.getSolution());
		}
		catch(Exception e){LOGGER.log(Level.SEVERE,"exception",e);}
	}
	/*   */
	public void updateSolutionService(Issue i){
		try{
			tv.validateUpdateSolution(i.getTransaction().getId(),i.getEmployee().getId(),i.getSolution());
			dao.updateSolutionByEmp(i.getTransaction().getId(),i.getEmployee().getId(),i.getSolution());
		}
		catch(Exception e){LOGGER.log(Level.SEVERE,"exception occur",e);}
	}
	/*   */
	public void closeTicketServer(Transaction t){
		try{
			tv.validateCloseTicket(t.getStatus(),t.getId(),t.getUsers().getId());
			dao.closeTicket(t.getStatus(),t.getId(),t.getUsers().getId());
		}
		catch(Exception e){LOGGER.log(Level.SEVERE,"exception occur",e);}
	}
	/*   */
	public void assingTicketService(Transaction t) throws ValidatorException{
		try{
			tv.validateAssignTicket(t.getId(),t.getEmployee().getId());
		    dao.assignTicket(t.getId(), t.getEmployee().getId());
		}
		catch(Exception e){LOGGER.log(Level.SEVERE,"exception occurs",e);}
		}
	/*     */
	public void reassingTicketService(Transaction t) throws ValidatorException{
		try{
			tv.validateAssignTicket(t.getId(),t.getEmployee().getId());
		    dao.reassignTicket(t.getId(), t.getEmployee().getId());
		}
		catch(Exception e){LOGGER.log(Level.SEVERE,"exception occurs",e);}
		}
	/*      */
	public void listByUserIdService(Transaction t){
		try{
			tv.validateListByUserId(t.getUsers().getId());
			dao.listByUserId(t.getUsers().getId());
		}
		catch(Exception e){LOGGER.log(Level.SEVERE,"exception occurs",e);}
	}
	public List<Transaction> listByEmpIdService(Transaction t){
		List<Transaction> message=null;
		try{
			tv.validateListByEmpId(t.getEmployee().getId());
			message=dao.listByEmpId(t.getEmployee().getId());
			return message;
		}
		catch(Exception e){LOGGER.log(Level.SEVERE,"exception occurs",e);}
		return listByEmpIdService(t);
	}
	
	}



