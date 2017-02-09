package com.ticket.testservice;

import com.ticket.exception.ValidatorException;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Issue;
import com.ticket.model.Transaction;
import com.ticket.model.User;
import com.ticket.service.TicketDetailService;

public class TestTicketService {

	public static void main(String[] args) throws ValidatorException {
User u =new User();		
Transaction t = new Transaction();
Department d= new Department();
Issue i = new Issue();
Employee e=new Employee();
TicketDetailService ts = new TicketDetailService();
u.setId(3);t.setUsers(u);
d.setName("hr");t.setDepartment(d);
t.setId(4);
t.setSubject("study");
t.setDesc("material");
t.setPriority("low");
t.setStatus("closed");
//ts.closeTicketServer(t);
System.out.println(ts.createticketService(t));
//ts.updateByUserService(t);
/*for issue table*/
i.setTransaction(t);
e.setId(4);i.setEmployee(e);
t.setEmployee(e);
//i.setSolution("restarting");
ts.assingTicketService(t);
//ts.reassingTicketService(t);
//ts.replyTicketService(i);
//ts.updateSolutionService(i);
ts.listByEmpIdService(t);

	}
}