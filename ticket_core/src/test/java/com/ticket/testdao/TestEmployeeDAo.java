package com.ticket.testdao;

import com.ticket.dao.EmployeeDAO;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Role;

public class TestEmployeeDAo {

	public static void main(String[] args) {
		Employee e = new Employee();
		Department d = new Department();
		EmployeeDAO dao = new EmployeeDAO();
		Role r = new Role();
		
//		e.setId(1);
		d.setId(1);
		e.setDepartment(d);
		r.setId(3);
		e.setRole(r);
		e.setName("kumar");
		e.setEmailId("kumar@gmail.com");
		e.setPassword("kumar123");
		dao.save(e);
//		dao.update(e);
//		System.out.println(dao.list());
		

	}

}
