package com.ticket.testdao;

import java.time.LocalDate;

import com.ticket.dao.TransactionDAO;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Transaction;
import com.ticket.model.Users;

public class TestTransactionDAO {

	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		Transaction t = new Transaction();
		Employee e = new Employee();
		Users u = new Users();
		Department d = new Department();
		u.setId(2);
		e.setId(2);
		d.setId(2);
		t.setUsers(u);
		t.setEmployee(e);
		t.setDepartment(d);
		t.setId(1);
		t.setSubject("laptop");
		t.setDesc("open");
		t.setDate(LocalDate.parse("2017-02-21"));
		t.setStatus("resolved");
	dao.save(t);

	}

}
