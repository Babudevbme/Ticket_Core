package com.ticket.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.util.ConnectionUtil;

public class DepartmentDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
	public void save(Department dept) {
		String sql = "INSERT  INTO DEPARTMENT(NAME) VALUES(?)";
		Object[] params = {dept.getName()};
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No. of rows insetred %d", rows);
	}

	public void update(Department d) {
		String sql = "UPDATE DEPARTMENT  SET NAME=? WHERE ID=?";
		Object[] params = {d.getName(),d.getId()};
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "DELETE FROM DEPARTMENT WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No. of rows deleted %d", rows);	}
	public List <Department> list()
	{
		String sql="SELECT *FROM DEPARTMENT ";
	return jdbcTemplate.query(sql,( rs,params)->{
			Department dept= new Department();
			dept.setId(rs.getInt("id"));
			dept.setName(rs.getString("name"));
			dept.setActive(rs.getBoolean("active"));
			return dept;
			
		});
	}
	public Department listById(int id) {

		String sql = "select id,name from department where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Department dept = new Department();
			dept.setId(rs.getInt("id"));
			dept.setName(rs.getString("NAME"));
			return dept;
		});

	}

	public Department listByName(String name) {

		String sql = "select id from department where name=?";
		Object[] params = { name };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Department dept = new Department();
dept.setId(rs.getInt("id"));
return dept;
		});

	}
	

}
