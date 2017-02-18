package com.ticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Role;
import com.ticket.util.ConnectionUtil;

public class EmployeeDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = Logger.getLogger(EmployeeDAO.class.getName());

	public Object save(Employee emp) {
		String sql = "INSERT INTO EMPLOYEE(DEPT_ID, ROLE_ID,NAME,EMAIL_ID,PASSWORD) VALUES(?,?,?,?,?)";
		Object[] params = { emp.getDepartment().getId(),emp.getRole().getId(), emp.getName(), emp.getEmailId(), emp.getPassword() };
		return jdbcTemplate.update(sql, params);
	}

	public void update(Employee emp) {
		String sql = "UPDATE EMPLOYEE SET DEPT_ID=?,ROLE_ID=?,NAME=?,EMAIL_ID=?,PASSWORD=? WHERE ID=?";
		Object[] params = { emp.getDepartment().getId(),emp.getRole().getId(), emp.getName(), emp.getEmailId(), emp.getPassword(), emp.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No. of rows updated %d", rows);

	}

	public void delete(int id) {
		String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No. of rows deleted %d", rows);
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
		});}
		
		/*for user login*/
	 	
		public Object login(String email,String password) throws Exception{
			try{
				 String sql="select *from employee where email_id=? and password=? ";
				 Object[] params={email,password};
				return jdbcTemplate.queryForObject(sql, params,(rs,roeNum)->
				{Employee emp = new Employee();
				Role role=new Role();
				Department dept=new Department();
				dept.setId(rs.getInt("id"));
				role.setId(rs.getInt("id"));
				emp.setId(rs.getInt("id"));
				emp.setDepartment(dept);
				emp.setRole(role);
				emp.setName(rs.getString("name"));
				emp.setEmailId(rs.getString("email_id"));
				emp.setPassword(rs.getString("password"));
				emp.setActive(rs.getBoolean("active"));
				return emp;});
				}
				
				catch(EmptyResultDataAccessException e){
					return null;

			
			}
		}
			 
		 

	}




