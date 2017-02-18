package com.ticket.testdao;

import com.ticket.dao.EmployeeDAO;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Role;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		Employee emp = new Employee();
		Department dept = new Department();
		EmployeeDAO dao = new EmployeeDAO();
		Role r = new Role();
		
//		e.setId(1);
		dept.setId(2);
		emp.setDepartment(dept);
		r.setId(4);
		emp.setRole(r);
		emp.setName("kumar");
		emp.setEmailId("kumarr@gmail.com");
		emp.setPassword("kumar123");
		System.out.println("hi");
//		try {
//			System.out.println(dao.login("babudev@gmail.com","babu"));
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		System.out.println(dao.save(e));
//		dao.update(e);
		System.out.println(dao.list());
		

	}

}
