package com.ticket.testdao;

import com.ticket.dao.TicketDetailtDAO;
import com.ticket.model.User;

public class TestTicketDetailDAO {

	public static void main(String[] args) throws Exception {
		TicketDetailtDAO dao =new TicketDetailtDAO();
		User user=new User();
//		System.out.println(dao.closeTicket(11,3));
		user.setId(11);
//		t.setUsers(u);
		
//		dao.createTicket(1,"finance", "error in jave", "fault","high");
//		dao.createTicket(1, "hr", "test", "test_desc", "process");
//		System.out.println(dao.listByEmpId(2));
//		System.out.println(dao.listByUserId(11));
//		dao.assignTicket(2, 1);
//		dao.reassignTicket(2,4);
//		System.out.println(dao.updateTicketByUser(1, 1, "laptop", "not working"));
//		dao.deleteTicket(1,6);
//		dao.updateSolutionByEmp(1, 1,"clear memory");
//		System.out.println(dao.replyTicket(11,"test"));
System.out.println(dao.solutionList(5));		

	}
}
