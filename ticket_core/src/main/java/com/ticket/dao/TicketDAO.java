package com.ticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Transaction;
import com.ticket.model.Users;
import com.ticket.util.ConnectionUtil;

public class TransactionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Transaction t) {
		String sql = "INSERT INTO TRANSACTION(USER_ID,EMP_ID,DEPT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,STATUS) VALUES(?,?,?,?,?,?,?)";
		Object[] params = {t.getUsers().getId(),t.getEmployee().getId(),t.getDepartment().getId()
				,t.getSubject(),t.getDesc(),t.getDate(),t.getStatus()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows inserted:" + rows);
	}

	public void update(Transaction t) {
		String sql = "UPDATE TRANSACTION  SETUSER_ID=?,EMP_ID=?,DEPT_ID=?,SUBJECT=?,DESCRIPTION=?,CREATED_DATE=?,STATUS=? WHERE ID=?";
		Object[] params = {t.getUsers().getId(),t.getEmployee().getId(),t.getDepartment().getId()
				,t.getSubject(),t.getDesc(),t.getDate(),t.getStatus(),t.getId()};
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
		String sql="SELECT *FROM ";
		return jdbcTemplate.query(sql,( rs,params)-> convert(rs));
	}

	private Transaction convert(ResultSet rs) throws SQLException {
		Transaction t= new Transaction();
		Users u = new Users();
		Employee e = new Employee();
		Department d = new Department();
		u.setId(rs.getInt("user_id"));
		e.setId(rs.getInt("emp_id"));
		d.setId(rs.getInt("dept_id"));
		t.setUsers(u);
		t.setEmployee(e);
		t.setDepartment(d);
		t.setSubject("subject");
		t.setDesc("description");
		t.setDate(rs.getDate("created_date").toLocalDate());
		t.setStatus(rs.getString("status"));
		return t;
	}
	

}
