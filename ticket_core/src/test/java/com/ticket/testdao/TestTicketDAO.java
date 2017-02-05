package com.ticket.testdao;

import java.time.LocalDate;

import com.ticket.dao.TicketDAO;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Transaction;
import com.ticket.model.User;

public class TestTicketDAO {

	public static void main(String[] args) {
		TicketDAO dao = new TicketDAO();
		Transaction t = new Transaction();
		Employee e = new Employee();
		User u = new User();
		Department d = new Department();
		u.setId(1);
		e.setId(1);
		d.setId(2);
		t.setUsers(u);
		t.setEmployee(e);
		t.setDepartment(d);
		t.setId(2);
		t.setSubject("laptop");
		t.setDesc("not work");
		t.setStatus("");
		t.setPriority("low");
//		dao.save(t);
		dao.update(t);
//dao.delete(2);
System.out.println(dao.list());
	}

}
