package com.ticket.testdao;

import com.ticket.dao.IssueDAO;
import com.ticket.model.Issue;
import com.ticket.model.Transaction;

public class TestIssuesDAo {

	public static void main(String[] args) {
		Issue i = new Issue();
		IssueDAO dao = new IssueDAO();
		Transaction t = new Transaction();
		t.setId(3);
		i.setTransaction(t);
		i.setSolution("success");
		dao.save(i);

	}

}
