package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Solution;
import com.ticket.model.Transaction;
import com.ticket.util.ConnectionUtil;

public class SolutionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Solution solution) {
		String sql = "INSERT INTO ISSUES(TICKET_ID,SOLUTION) VALUES(?,?)";
		Object[] params = {solution.getTransaction().getId(),solution.getSolution()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows inserted:" + rows);
	}

	public void update(Solution solution) {
		String sql = "UPDATE ISSUES SET TICKET_ID=?,SOLUTION=? WHERE ID=?";
		Object[] params = {solution.getTransaction().getId(),solution.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows updated" + rows);

	}

	public void delete(int id) {
		String sql = "DELETE FROM ISSUES WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Number of rows deleted:" + rows);
	}
public List <Solution> list()
{
	String sql="SELECT *FROM ISSUES";
	return jdbcTemplate.query(sql,( rs,params)->{
		Solution i= new Solution();
		Transaction t = new Transaction();
		i.setId(rs.getInt("id"));
		t.setId(rs.getInt("ticket_id"));
		i.setTransaction(t);
		i.setSolution("solution");
		return i;
		
	});
	
}

}
