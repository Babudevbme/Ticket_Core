package com.ticket.testservice;

import com.ticket.exception.ValidatorException;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Role;
import com.ticket.validator.EmployeeValidator;

public class TestEmployeeService {

	public static void main(String[] args) throws ValidatorException {
		EmployeeValidator empValidator = new EmployeeValidator();
		Employee emp = new Employee();
		Department department = new Department();
		Role role = new Role();
		emp.setName("yash");
		department.setId(2);
		emp.setDepartment(department);
		emp.setRole(role);
		role.setId(4);
		emp.setEmailId("babudev95@gmail.com");
		emp.setPassword("");
		empValidator.validateRegister(emp.getName(), emp.getDepartment().getId(), emp.getRole().getId(), emp.getEmailId(),emp.getPassword());

					
	}

}
