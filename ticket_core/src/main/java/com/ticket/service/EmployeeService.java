package com.ticket.service;

import javax.xml.bind.ValidationException;
import com.ticket.dao.EmployeeDAO;
import com.ticket.exception.ValidatorException;
import com.ticket.model.Employee;
import com.ticket.validator.EmployeeValidator;

public class EmployeeService {
	EmployeeDAO dao = new EmployeeDAO();
	EmployeeValidator empValidator = new EmployeeValidator();
public Object registerService(Employee emp) {
	try {
		empValidator.validateRegister(emp.getName(),emp.getDepartment().getId(),emp.getRole().getId(), emp.getEmailId()
				,emp.getPassword());
		 return dao.save(emp);

	} catch (ValidatorException e1) {
		e1.printStackTrace();
	}
	return emp;

	}

	public Object login(Employee emp) throws ValidationException {

		try {
			empValidator.validateLogin(emp.getEmailId(), emp.getPassword());
			return dao.login(emp.getEmailId(), emp.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;

	}

}
