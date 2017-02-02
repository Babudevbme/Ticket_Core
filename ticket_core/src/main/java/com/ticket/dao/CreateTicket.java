package com.ticket.dao;

import com.ticket.model.Employee;
import com.ticket.model.Transaction;
import com.ticket.model.User;

public class CreateTicket {
	public void createTicket(int userId, String type, String subject, String description, String status) {
		TransactionDAO tdao = new TransactionDAO();
		Transaction t = new Transaction();
		User u = new User();
		u.setId(userId);
		t.setUsers(u);
		Employee e = new Employee();
		e.setId(1);
		t.setEmployee(e);
		DepartmentDAO d = new DepartmentDAO();
		t.setDepartment(d.listByName(type));
		t.setSubject(subject);
		t.setDesc(description);
		tdao.save(t);
	}

}
