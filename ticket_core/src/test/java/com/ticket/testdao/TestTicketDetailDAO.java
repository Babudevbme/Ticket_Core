package com.ticket.testdao;

import java.time.LocalDate;

import com.ticket.dao.TicketDetailtDAO;

public class TestTicketDetailDAO {

	public static void main(String[] args) {
		TicketDetailtDAO dao =new TicketDetailtDAO();
//		dao.closeTicket("closed",1,1);
//		System.out.println(dao.listByUserId(2));
//		dao.createTicket(1,"finance", "error in jave", "fault","high");
//		dao.createTicket(1, "hr", "test", "test_desc", "process");
//		System.out.println(dao.listByEmpId(2));
//		System.out.println(dao.listByUserId(1));
		dao.assignTicket(2, 1);
//		dao.reassignTicket(2,4);
//		dao.updateTicketByUser(2, 1, "laptop", "not working");
//		dao.deleteTicket(1,6);
//		dao.updateSolutionByEmp(1, 1,"clear memory");
//		dao.replyTicket(1,"test");

	}

}
