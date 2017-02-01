package com.ticket.testdao;

import com.ticket.dao.IssuesDAO;
import com.ticket.model.Issues;
import com.ticket.model.Transaction;

public class TestIssuesDAo {

	public static void main(String[] args) {
		Issues i = new Issues();
		IssuesDAO dao = new IssuesDAO();
		Transaction t = new Transaction();
		t.setId(3);
		i.setTransaction(t);
		i.setSolution("success");
		dao.save(i);

	}

}
