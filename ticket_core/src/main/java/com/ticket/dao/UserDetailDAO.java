package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Users;
import com.ticket.util.ConnectionUtil;

public class UsersDAO {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public void save(Users users)
	{
		String sql="INSERT INTO USERS(NAME,EMAIL_ID,PASSWORD) VALUES(?,?,?)";
		Object[]params={users.getName(),users.getEmailId(),users.getPassword()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows inserted:" +rows);
	}
	
	
	
	public void update(Users users)
	{
		String sql="UPDATE USERS SET NAME=?,EMAIL_ID=?,PASSWORD=? WHERE ID=?";
		Object[]params={users.getName(),users.getEmailId(),users.getPassword(),users.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated" +rows);
				
	}
	public void delete(int id)
	{
		String sql="DELETE FROM USERS WHERE ID=?";
		Object[]params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:" +rows);
	}
 	
	
	public List <Users> list()
	{
		String sql="SELECT *FROM USERS";
		List <Users > list=jdbcTemplate.query(sql,( rs,params)->{
			Users u = new Users();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setEmailId(rs.getString("email_id"));
			u.setActive(rs.getBoolean("active"));
			return u;

});
		return list;
	}


}
