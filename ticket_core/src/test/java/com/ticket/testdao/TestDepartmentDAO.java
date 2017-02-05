package com.ticket.testdao;

import com.ticket.dao.DepartmentDAO;
import com.ticket.model.Department;

public class TestDepartmentDAO {

	public static void main(String[] args) {
DepartmentDAO dao = new DepartmentDAO();
Department d = new Department();
//d.setId(2);
d.setName("HR");
dao.save(d);
//dao.update(d);
//dao.delete(3);
System.out.println(dao.list());

	}

}
