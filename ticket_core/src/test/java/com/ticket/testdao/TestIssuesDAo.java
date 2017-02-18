package com.ticket.testdao;

import com.ticket.dao.SolutionDAO;
import com.ticket.model.Solution;
import com.ticket.model.Transaction;

public class TestIssuesDAo {

	public static void main(String[] args) {
		Solution issue = new Solution();
		SolutionDAO dao = new SolutionDAO();
		Transaction t = new Transaction();
		t.setId(3);
		issue.setTransaction(t);
		issue.setSolution("success");
		dao.save(issue);

	}

}
