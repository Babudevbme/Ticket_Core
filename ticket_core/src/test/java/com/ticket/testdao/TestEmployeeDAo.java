package com.ticket.testdao;

import com.ticket.dao.EmployeeDAO;
import com.ticket.model.Department;
import com.ticket.model.Employee;

public class TestEmployeeDAo {

	public static void main(String[] args) {
		Employee e = new Employee();
		Department d = new Department();
		EmployeeDAO dao = new EmployeeDAO();
		e.setId(1);
		d.setId(1);
		e.setDepartment(d);
		e.setName("Yash");
		e.setEmailId("yash@gmail");
		e.setPassword("yash");
//		dao.save(e);
//		dao.update(e);
		System.out.println(dao.list());
		

	}

}
