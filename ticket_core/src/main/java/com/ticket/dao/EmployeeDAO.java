package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.util.ConnectionUtil;

public class EmployeeDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Employee e) {
		String sql = "INSERT INTO EMPLOYEE(DEPT_ID,NAME,EMAIL_ID,PASSWORD) VALUES(?,?,?,?)";
		Object[] params = { e.getDepartment().getId(), e.getName(), e.getEmailId(), e.getPassword() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows inserted:" + rows);
	}

	public void update(Employee e) {
		String sql = "UPDATE EMPLOYEE SET DEPT_ID=?,NAME=?,EMAIL_ID=?,PASSWORD=? WHERE ID=?";
		Object[] params = { e.getDepartment().getId(), e.getName(), e.getEmailId(), e.getPassword(), e.getId() };
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
		List<Employee> list = jdbcTemplate.query(sql, (rs, params) -> {
			Employee e = new Employee();
			Department d = new Department();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			d.setId(rs.getInt("dept_id"));
			e.setDepartment(d);
			e.setEmailId(rs.getString("email_id"));
			e.setPassword(rs.getString("password"));
			e.setActive(rs.getBoolean("active"));
			return e;

		});
		return list;
	}

}
