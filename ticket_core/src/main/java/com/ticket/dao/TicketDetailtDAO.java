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

public class TicketDetailtDAO {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	/* create ticket*/
	public void createTicket(int userId, String deptName, String subject, String description,String priority) {
		TicketDAO tdao = new TicketDAO();
		Transaction t = new Transaction();
		User u = new User();
		u.setId(userId);
		t.setUsers(u);
		DepartmentDAO d = new DepartmentDAO();
		t.setDepartment(d.listByName(deptName));
		t.setSubject(subject);
		t.setDesc(description);
		t.setPriority(priority);
		tdao.save(t);
	}
	public void updateTicketByUser(int id,int userId,String subject,String description) {
		String sql="UPDATE TRANSACTION SET SUBJECT=?,DESCRIPTION=?,STATUS=? WHERE ID=? AND USER_ID=?";
		Object[] params={subject,description,"open",id,userId};
		jdbcTemplate.update(sql, params);
	}
	public void replyTicket(int ticketId,String solution){
		String sql="INSERT ISSUES(TICKET_ID,EMP_ID,SOLUTION) VALUES(?,(SELECT EMP_ID FROM TRANSACTION WHERE ID=?),?)";
		Object[] params={ticketId,ticketId,solution};
		jdbcTemplate.update(sql, params);
	}
	
	public void updateSolutionByEmp(int ticketId,int empId, String subject) 
	{
		String sql="UPDATE ISSUES SET SOLUTION=? WHERE TICKET_ID=? AND EMP_ID=?";
		Object[] params={subject,ticketId,empId};
		jdbcTemplate.update(sql, params);
	}
	public void closeTicket(String status ,int id,int userId){
		String sql="update transaction set status=? where id=? and user_id=? ";
		Object[] params={status,id,userId};
		jdbcTemplate.update(sql, params);
		
	}
	
	public void assignTicket(int ticketId,int employeeId ){
		String sql="UPDATE TRANSACTION SET EMP_ID=?,ASSINGTO=(SELECT NAME FROM EMPLOYEE WHERE ID=?),"
				+ "STATUS=? WHERE ID=? AND STATUS=? AND DEPT_ID=(SELECT  DEPT_ID FROM EMPLOYEE WHERE ID=?) ";
		Object[] params={employeeId,employeeId,"inprogress",ticketId,"open",employeeId};
		 jdbcTemplate.update(sql,params);
	}
	public void reassignTicket(int ticketId,int employeeId ){
		String sql="UPDATE TRANSACTION SET EMP_ID=?,ASSINGTO=(SELECT NAME FROM EMPLOYEE WHERE ID=?),"
				+ "STATUS=? WHERE ID=? AND STATUS=? AND DEPT_ID=(SELECT  DEPT_ID FROM EMPLOYEE WHERE ID=?) ";
		Object[] params={employeeId,employeeId,ticketId};
		jdbcTemplate.update(sql,params);
	}

	public List <Transaction> listByUserId(int userId)
	{
		String sql="SELECT *FROM TRANSACTION WHERE USER_ID=? ";
		Object[] params={userId};
		return jdbcTemplate.query(sql,params,( rs,rownum)-> convert(rs));
	}
	public List <Transaction> listByEmpId(int empId)
	{
		String sql="SELECT *FROM TRANSACTION WHERE EMP_ID=? ";
		Object[] params={empId};
		return jdbcTemplate.query(sql,params,( rs,rownum)-> convert(rs));
		
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
		t.setDesc(rs.getString("DESCRIPTION"));
		t.setTimeStamp(rs.getTimestamp("created_date").toLocalDateTime());
		t.setStatus(rs.getString("status"));
		t.setPriority(rs.getString("priority"));
		return t;
	}
	public int deleteTicket(int empId,int ticketId){
		String sql="DELETE FROM TRANSACTION WHERE ID=? AND (SELECT ROLE_ID FROM EMPLOYEE WHERE ID=?)=1 ";
		Object [] params={ticketId,empId};
		return jdbcTemplate.update(sql, params);
		
		
	}
	

	

}
