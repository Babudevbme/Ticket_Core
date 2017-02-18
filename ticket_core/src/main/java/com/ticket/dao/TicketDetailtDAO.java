package com.ticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Solution;
import com.ticket.model.Transaction;
import com.ticket.model.User;
import com.ticket.util.ConnectionUtil;

public class TicketDetailtDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/* create ticket */
	public void createTicket(int userId, String deptName, String subject, String description, String priority) {
		TransactionDAO tdao = new TransactionDAO();
		Transaction transaction = new Transaction();
		User user = new User();

		user.setId(userId);
		transaction.setUsers(user);
		DepartmentDAO d = new DepartmentDAO();
		transaction.setDepartment(d.listByName(deptName));
		transaction.setSubject(subject);
		transaction.setDesc(description);
		transaction.setPriority(priority);
		tdao.save(transaction);
	}

	public Object updateTicketByUser(int id, int userId, String subject, String description) {
		String sql = "UPDATE TRANSACTION SET SUBJECT=?,DESCRIPTION=?,STATUS=? WHERE ID=? AND USER_ID=?";
		Object[] params = { subject, description, "open", id, userId };
		if (jdbcTemplate.update(sql, params) != 0) {
			return 1;
		}
		return null;
	}

	public Object replyTicket(int ticketId, String solution) throws Exception {
		try {
			String sql = "INSERT ISSUES(TICKET_ID,EMP_ID,SOLUTION) VALUES(?,(SELECT EMP_ID FROM TRANSACTION WHERE ID=?),?)";
			Object[] params = { ticketId, ticketId, solution };
			return jdbcTemplate.update(sql, params);
		} catch (Exception e) {
			return null;
		}
	}

	public Object updateSolutionByEmp(int ticketId, int empId, String solution) {
		String sql = "UPDATE ISSUES SET SOLUTION=? WHERE TICKET_ID=? AND EMP_ID=?";
		Object[] params = { solution, ticketId, empId };
		if (jdbcTemplate.update(sql, params) != 0) {
			return 1;
		}
		return null;
	}

	public Object closeTicket(int id, int userId) {
		String sql = "update transaction set status=? where id=? and user_id=? ";
		Object[] params = { "closed", id, userId };
		if (jdbcTemplate.update(sql, params) != 0) {
			return 1;
		} else {
			return null;
		}

	}

	public void assignTicket(int ticketId, int employeeId) {
		String sql = "UPDATE TRANSACTION SET EMP_ID=?,ASSINGTO=(SELECT NAME FROM EMPLOYEE WHERE ID=?),"
				+ "STATUS=? WHERE ID=? AND STATUS=? AND DEPT_ID=(SELECT  DEPT_ID FROM EMPLOYEE WHERE ID=?) ";
		Object[] params = { employeeId, employeeId, "inprogress", ticketId, "open", employeeId };
		jdbcTemplate.update(sql, params);
	}

	public void reassignTicket(int ticketId, int employeeId) {
		String sql = "UPDATE TRANSACTION SET EMP_ID=?,ASSINGTO=(SELECT NAME FROM EMPLOYEE WHERE ID=?) WHERE ID=? AND  DEPT_ID=(SELECT DEPT_ID FROM EMPLOYEE WHERE ID=?) ";
		Object[] params = { employeeId, employeeId, ticketId, employeeId };
		jdbcTemplate.update(sql, params);
	}

	public List<Transaction> listByUserId(int userId) {
		String sql = "SELECT * FROM TRANSACTION WHERE USER_ID=? ";
		Object[] params = { userId };
		return jdbcTemplate.query(sql, params, (rs, rownum) -> convert(rs));
		
	}

	public List<Transaction> listByEmpId(int empId) {
		String sql = "SELECT *FROM TRANSACTION WHERE EMP_ID=? ";
		Object[] params = { empId };
		return jdbcTemplate.query(sql, params, (rs, rownum) -> convert(rs));

	}

	private Transaction convert(ResultSet rs) throws SQLException {
		Transaction transaction = new Transaction();
		Department dept = new Department();
		Employee emp = new Employee();
		User user = new User();

		transaction.setId(rs.getInt("id"));
		user.setId(rs.getInt("user_id"));
		emp.setId(rs.getInt("emp_id"));
		dept.setId(rs.getInt("dept_id"));
		transaction.setUsers(user);
		System.out.println(user);

		transaction.setEmployee(emp);
		transaction.setDepartment(dept);
		transaction.setAssignTo(rs.getString("assingto"));
		transaction.setSubject(rs.getString("SUBJECT"));
		transaction.setDesc(rs.getString("DESCRIPTION"));
		transaction.setTimeStamp(rs.getTimestamp("created_date").toLocalDateTime());
		transaction.setStatus(rs.getString("status"));
		transaction.setPriority(rs.getString("priority"));
		return transaction;
	}

	public int deleteTicket(int empId, int ticketId) {
		String sql = "DELETE FROM TRANSACTION WHERE ID=? AND (SELECT ROLE_ID FROM EMPLOYEE WHERE ID=?)=1 ";
		Object[] params = { ticketId, empId };
		return jdbcTemplate.update(sql, params);

	}

	public List<Solution> solutionList(int empId)  {
		
			String sql = "select * from Issues where emp_id=?";
			Object[] params = { empId };
			System.out.println(empId);

			return jdbcTemplate.query(sql, params, (rs, rownum) -> listSolution(rs));


	}

	private Solution listSolution(ResultSet rs) throws SQLException {
		Transaction transaction = new Transaction();
		Solution solution = new Solution();
		Employee emp = new Employee();
		solution.setId(rs.getInt("id"));
		emp.setId(rs.getInt("emp_id"));
		solution.setEmployee(emp);
		transaction.setId(rs.getInt("ticket_id"));
		solution.setTransaction(transaction);

		solution.setSolution(rs.getString("SOLUTION"));
		System.out.println(solution);
		return solution;
	}
	
	

}
