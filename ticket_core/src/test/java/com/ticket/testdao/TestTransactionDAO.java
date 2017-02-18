package com.ticket.testdao;

import com.ticket.dao.TransactionDAO;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Transaction;
import com.ticket.model.User;

public class TestTransactionDAO {

	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		Transaction transaction = new Transaction();
		Employee emp = new Employee();
		User user = new User();
		Department d = new Department();
		user.setId(11);
		emp.setId(1);
		d.setId(2);
		transaction.setUsers(user);
		transaction.setEmployee(emp);
		transaction.setDepartment(d);
		transaction.setId(2);
		transaction.setSubject("laptop");
		transaction.setDesc("not work");
		transaction.setStatus("");
		transaction.setPriority("low");
////		dao.save(t);
//		dao.update(t);
//dao.delete(2);
		
System.out.println(dao.list());
	}

}
