package com.ticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Role;
import com.ticket.util.ConnectionUtil;

public class EmployeeDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Employee e) {
		String sql = "INSERT INTO EMPLOYEE(DEPT_ID, ROLE_ID,NAME,EMAIL_ID,PASSWORD) VALUES(?,?,?,?,?)";
		Object[] params = { e.getDepartment().getId(),e.getRole().getId(), e.getName(), e.getEmailId(), e.getPassword() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows inserted:" + rows);
	}

	public void update(Employee e) {
		String sql = "UPDATE EMPLOYEE SET DEPT_ID=?,ROLE_ID=?,NAME=?,EMAIL_ID=?,PASSWORD=? WHERE ID=?";
		Object[] params = { e.getDepartment().getId(),e.getRole().getId(), e.getName(), e.getEmailId(), e.getPassword(), e.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows updated" + rows);

	}

	public void delete(int id) {
		String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows deleted:" + rows);
	}
		
	
	public List<Employee> list() {
		String sql = "SELECT *FROM EMPLOYEE ";
		return jdbcTemplate.query(sql, (rs, params) ->convert(rs));
	}

	private Employee convert(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		Department d = new Department();
		Role r = new Role();
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		d.setId(rs.getInt("dept_id"));
		e.setDepartment(d);
		r.setId(rs.getInt("role_id"));
		e.setRole(r);
		e.setEmailId(rs.getString("email_id"));
		e.setPassword(rs.getString("password"));
		e.setActive(rs.getBoolean("active"));
		return e;
	}
	public Employee listById(int id) {

		String sql = "select id,name from users where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Employee u = new Employee();
			u.setId(rs.getInt("id"));;
			u.setName(rs.getString("NAME"));
			return u;
		});

	}

}


