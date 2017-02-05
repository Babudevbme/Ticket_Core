package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.User;
import com.ticket.util.ConnectionUtil;

public class UserDetailDAO {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public void save(User users)
	{
		String sql="INSERT INTO USERS(NAME,EMAIL_ID,PASSWORD) VALUES(?,?,?)";
		Object[]params={users.getName(),users.getEmailId(),users.getPassword()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows inserted:" +rows);
	}
	
	
	
	public void update(User users)
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
	
	/*for user register*/
	public void register(String name ,String email,String password ){
		String sql="insert users(name,email_id,password) values(?,?,?)";
		Object[] params={name,email,password};
		jdbcTemplate.update(sql, params);
		}
	/*for user login*/
 	
	public String login(String email,String password){
		 String sql="select name from users where email_id=? and password=? ";
		 Object[] params={email,password};
		return jdbcTemplate.queryForObject(sql, params, String.class);

		 
	 }
	
	public List <User> list()
	{
		String sql="SELECT *FROM USERS";
		return jdbcTemplate.query(sql,( rs,params)->{
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setEmailId(rs.getString("email_id"));
			u.setActive(rs.getBoolean("active"));
			return u;

});
		
	}


}
