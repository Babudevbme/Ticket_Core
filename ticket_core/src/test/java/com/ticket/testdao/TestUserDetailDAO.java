package com.ticket.testdao;

import com.ticket.dao.UserDetailDAO;
import com.ticket.model.User;

public class TestUserDetailDAO {

	public static void main(String[] args) {
User users = new User();
UserDetailDAO dao = new UserDetailDAO();
users.setId(1);
users.setName("babu.k");
users.setEmailId("babudev@gmail");
users.setPassword("babudev");
//dao.save(users);
//dao.update(users);
//dao.delete(1);

//System.out.println(dao.list());
//dao.register("babu", "babu@gamil", "babu123");
System.out.println(dao.login("babudev@gmail","babudev"));
//System.out.println(dao.login("solai@gmail.com", "sss"));

}

}
