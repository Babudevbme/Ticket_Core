package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.util.ValidatorUtil;

public class TicketDetailValidator {
	ValidatorUtil validatorUtil = new ValidatorUtil();
public void validateCreateTicket(int userId, String deptName, String subject, String description,
		String priority) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(userId, "user_Id");
	validatorUtil.rejectIfNullOrEmpty(deptName, "dept_Name");
	validatorUtil.rejectIfNullOrEmpty(subject, "Sub");
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
public void validateUpdateSolution(int ticketId,int empId, String subject) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(ticketId, "ticketId");
	validatorUtil.rejectIfNullOrEmpty(subject, "subject");
	validatorUtil.rejectIfNegativeOrZeroOrNull(empId, "emp_id");
}
public void validateCloseTicket(String status ,int id,int userId) throws ValidatorException{
	
validatorUtil.rejectIfNullOrEmpty(status, "status");
validatorUtil.rejectIfNegativeOrZeroOrNull(id, "id");
validatorUtil.rejectIfNegativeOrZeroOrNull(userId, "userId");
}
public void validateAssignTicket(int ticketId,int employeeId) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(ticketId, "ticketId");
	validatorUtil.rejectIfNegativeOrZeroOrNull(employeeId, "employeeId");
}
public void validateReassingTicket(int ticketId,int empId) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(ticketId, "ticketId");
	validatorUtil.rejectIfNegativeOrZeroOrNull(empId, "empId");
}
public void validateListByUserId(int userId) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(userId, "user_id");
}
public void validateListByEmpId(int empId) throws ValidatorException{
	validatorUtil.rejectIfNegativeOrZeroOrNull(empId, "emp_id");
}
}
