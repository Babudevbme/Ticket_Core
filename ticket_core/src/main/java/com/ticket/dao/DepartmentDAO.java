package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.util.ConnectionUtil;

public class DepartmentDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Department d) {
		String sql = "INSERT  INTO DEPARTMENT(NAME) VALUES(?)";
		Object[] params = {d.getName()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows inserted:" + rows);
	}

	public void update(Department d) {
		String sql = "UPDATE DEPARTMENT  SET NAME=? WHERE ID=?";
		Object[] params = {d.getName(),d.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows updated" + rows);

	}

	public void delete(int id) {
		String sql = "DELETE FROM DEPARTMENT WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows deleted:" + rows);
	}
	public List <Department> list()
	{
		String sql="SELECT *FROM DEPARTMENT ";
		List < Department> list=jdbcTemplate.query(sql,( rs,params)->{
			Department d= new Department();
			d.setId(rs.getInt("id"));
			d.setName(rs.getString("name"));
			d.setActive(rs.getBoolean("active"));
			return d;
			
		});
		return list;
	}
	

}
