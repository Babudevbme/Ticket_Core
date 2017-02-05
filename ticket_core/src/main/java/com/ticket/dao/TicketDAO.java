package com.ticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Transaction;
import com.ticket.model.User;
import com.ticket.util.ConnectionUtil;

public class TicketDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Transaction t) {
		String sql = "INSERT INTO TRANSACTION(USER_ID,DEPT_ID,SUBJECT,DESCRIPTION,PRIORITY) VALUES(?,?,?,?,?)";
		Object[] params = {t.getUsers().getId(),t.getDepartment().getId()
				,t.getSubject(),t.getDesc(),t.getPriority()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows inserted:" + rows);
	}

	public void update(Transaction t) {
		String sql = "UPDATE TRANSACTION  SET SUBJECT=?,DESCRIPTION=? WHERE ID=?";
		Object[] params = {t.getSubject(),t.getDesc(),t.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows updated" + rows);

	}

	public void delete(int id) {
		String sql = "DELETE FROM TRANSACTION WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows deleted:" + rows);
	}
	public List <Transaction> list()
	{
		String sql="SELECT *FROM TRANSACTION  ";
		return jdbcTemplate.query(sql,( rs,params)-> convert(rs));
	}

	private Transaction convert(ResultSet rs) throws SQLException {
		Transaction t= new Transaction();
		User u = new User();
		Employee e = new Employee();
		Department d = new Department();
		t.setId(rs.getInt("id"));
		u.setId(rs.getInt("user_id"));
		e.setId(rs.getInt("emp_id"));
		d.setId(rs.getInt("dept_id"));
		t.setUsers(u);
		t.setEmployee(e);
		t.setDepartment(d);
		t.setAssingTo(rs.getString("assingto"));
		t.setSubject(rs.getString("SUBJECT"));
		t.setTimeStamp(rs.getTimestamp("created_date").toLocalDateTime());
		t.setDesc(rs.getString("DESCRIPTION"));
		t.setStatus(rs.getString("status"));
		t.setPriority(rs.getString("priority"));

		return t;
	}
	

}
