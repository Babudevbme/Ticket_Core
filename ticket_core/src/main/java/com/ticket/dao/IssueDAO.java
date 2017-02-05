package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Issue;
import com.ticket.model.Transaction;
import com.ticket.util.ConnectionUtil;

public class IssueDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Issue i) {
		String sql = "INSERT INTO ISSUES(TICKET_ID,SOLUTION) VALUES(?,?)";
		Object[] params = {i.getTransaction().getId(),i.getSolution()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows inserted:" + rows);
	}

	public void update(Issue i) {
		String sql = "UPDATE ISSUES SET TICKET_ID=?,SOLUTION=? WHERE ID=?";
		Object[] params = {i.getTransaction().getId(),i.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows updated" + rows);

	}

	public void delete(int id) {
		String sql = "DELETE FROM ISSUES WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows deleted:" + rows);
	}
public List <Issue> list()
{
	String sql="SELECT *FROM ISSUES";
	return jdbcTemplate.query(sql,( rs,params)->{
		Issue i= new Issue();
		Transaction t = new Transaction();
		i.setId(rs.getInt("id"));
		t.setId(rs.getInt("ticket_id"));
		i.setTransaction(t);
		i.setSolution("solution");
		return i;
		
	});
	
}
public Issue listById(int id) {

	String sql = "select id,solution from Issue where id=?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
		Issue u = new Issue();
		u.setId(rs.getInt("id"));;
		u.setSolution(rs.getString("SOLUTION"));
		return u;
	});

}

}
