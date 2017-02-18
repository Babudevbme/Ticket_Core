package com.ticket.testdao;

import com.ticket.dao.DepartmentDAO;

public class TestDepartmentDAO {

	public static void main(String[] args) throws Exception {
DepartmentDAO dao = new DepartmentDAO();
//Department d = new Department();
////d.setId(2);
//d.setName("HR");
//dao.save(d);
////dao.update(d);
////dao.delete(3);
System.out.println(dao.listByName("hr"));
//System.out.println(dao.list());
//MailUtil.sendSimpleMail();
	}

}
