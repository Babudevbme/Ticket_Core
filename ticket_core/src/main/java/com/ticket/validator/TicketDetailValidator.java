package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.util.ValidatorUtil;

public class TicketDetailValidator {
	ValidatorUtil validatorUtil = new ValidatorUtil();
public void ValidateCreateTicket(int userId, String deptName, String subject, String description,
		String priority) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(userId, "user_Id");
	validatorUtil.rejectIfNullOrEmpty(deptName, "dept_Name");
	validatorUtil.rejectIfNullOrEmpty(subject, "subject");
	validatorUtil.rejectIfNullOrEmpty(description, "description");
	validatorUtil.rejectIfNullOrEmpty(priority, "priority");
}
public void validateUpdateTicketByUser(int id,int userId,String subject,String description) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(id, "ticket_it");
	validatorUtil.rejectIfNegativeOrZeroOrNull(userId, "user_id");
	validatorUtil.rejectIfNullOrEmpty(subject, "subject");
	validatorUtil.rejectIfNullOrEmpty(description, "description");
		
	}
public void validateReplyTicket(int ticketId,String solution) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(ticketId, "ticket_id");
	validatorUtil.rejectIfNullOrEmpty(solution, "solution");
}
public void updateSolution(int ticketId,int empId, String subject) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(ticketId, "ticketId");
	validatorUtil.rejectIfNullOrEmpty(subject, "subject");
}
public void closeTicket(String status ,int id,int userId) throws ValidatorException{
	
validatorUtil.rejectIfNullOrEmpty(status, "status");
validatorUtil.rejectIfNegativeOrZeroOrNull(id, "id");
validatorUtil.rejectIfNegativeOrZeroOrNull(userId, "userId");
}
public void assignTicket(int ticketId,int employeeId) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(ticketId, "ticketId");
	validatorUtil.rejectIfNegativeOrZeroOrNull(employeeId, "employeeId");
}
}
