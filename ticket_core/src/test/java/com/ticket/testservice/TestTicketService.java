package com.ticket.testservice;

import com.ticket.exception.ValidatorException;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Solution;
import com.ticket.model.Transaction;
import com.ticket.model.User;
import com.ticket.service.TicketDetailService;

public class TestTicketService {

	public static void main(String[] args) throws ValidatorException {
User user =new User();		
Transaction transaction = new Transaction();
Department dept= new Department();
Solution solution = new Solution();
Employee e=new Employee();
TicketDetailService ts = new TicketDetailService();
user.setId(3);transaction.setUsers(user);
dept.setName("hr");transaction.setDepartment(dept);
transaction.setId(1);
transaction.setSubject("study");
transaction.setDesc("material");
transaction.setPriority("low");
//t.setStatus("closed");
//System.out.println(ts.closeTicketServer(t));
System.out.println(ts.createticketService(transaction));
//System.out.println(ts.updateByUserService(t));
/*for issue table*/
solution.setTransaction(transaction);
//e.setId(4);i.setEmployee(e);
transaction.setEmployee(e);
solution.setSolution("sample");
//ts.assignTicketService(t);
//ts.reassingTicketService(t);
//System.out.println(ts.replyTicketService(i));
//System.out.println(ts.updateSolutionService(i));
//System.out.println(ts.listByEmpIdService(t));
//System.out.println(ts.listByUserIdService(11));
//System.out.println(ts.solutionList(5));
	}
}