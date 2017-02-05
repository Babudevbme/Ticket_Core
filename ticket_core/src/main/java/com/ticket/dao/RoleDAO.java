package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.EmployeeRole;
import com.ticket.util.ConnectionUtil;

public class EmployeeRoleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(EmployeeRole u) {
		String sql = "insert into EMP_ROLE(name) values(?)";
		Object[] params = {u.getName() };
		jdbcTemplate.update(sql, params);

	}

	public void update(EmployeeRole u) {
		String sql = "update EMP_ROLE set name=?  where id=?";
		Object[] params = { u.getId(), u.getName() };
		jdbcTemplate.update(sql, params);

	}

	

	

	public void delete(int id) {
		String sql = "delete from EMP_ROLE where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<EmployeeRole> list() {
		String sql = "select * from EMP_ROLE ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			EmployeeRole u = new EmployeeRole();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			u.setActive(rs.getBoolean("ACTIVE"));
			return u;

		});
	}

	

	public EmployeeRole listById(int id) {

		String sql = "select id,name from e_role where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			EmployeeRole u = new EmployeeRole();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			return u;
		});

	}


}
