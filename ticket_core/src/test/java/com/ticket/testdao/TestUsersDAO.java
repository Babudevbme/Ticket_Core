package com.ticket.testdao;

import com.ticket.dao.UsersDAO;
import com.ticket.model.Users;

public class TestUsersDAO {

	public static void main(String[] args) {
Users users = new Users();
UsersDAO dao = new UsersDAO();
users.setId(1);
users.setName("babu.k");
users.setEmailId("babudev@gmail");
users.setPassword("babudev");
//dao.save(users);
dao.update(users);
//dao.delete(1);

//System.out.println(dao.list());	
}

}
