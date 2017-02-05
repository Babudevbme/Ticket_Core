package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Role;
import com.ticket.util.ConnectionUtil;

public class RoleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Role u) {
		String sql = "insert into EMP_ROLE(name) values(?)";
		Object[] params = {u.getName() };
		jdbcTemplate.update(sql, params);

	}

	public void update(Role u) {
		String sql = "update EMP_ROLE set name=?  where id=?";
		Object[] params = { u.getId(), u.getName() };
		jdbcTemplate.update(sql, params);

	}

	
	public void delete(int id) {
		String sql = "delete from EMP_ROLE where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<Role> list() {
		String sql = "select * from EMP_ROLE ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Role u = new Role();
			u.setId(rs.getInt("ID"));
			u.setName(rs.getString("NAME"));
			u.setActive(rs.getBoolean("ACTIVE"));
			return u;

		});
	}

	
	public Role listById(int id) {

		String sql = "select id,name from e_role where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Role u = new Role();
			u.setId(rs.getInt("ID"));
			u.setName(rs.getString("NAME"));
			return u;
		});

	}


}
