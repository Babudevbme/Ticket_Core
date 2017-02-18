package com.ticket.testservice;

import javax.xml.bind.ValidationException;

import com.ticket.exception.ServiceException;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Role;
import com.ticket.model.User;
import com.ticket.service.EmployeeService;
import com.ticket.service.UserSevice;

public class TestUserService {

	public static void main(String[] args) throws  ServiceException, ValidationException  {
			User user = new User();
			EmployeeService empService = new EmployeeService();
			Employee emp=new Employee();
			user.setEmailId("babudev95@gmail.com");
			user.setPassword("babudev7");
		user.setName("kga");
			emp.setEmailId("babudev@gmail.com");
			emp.setPassword("babu");
			Department department = new Department();
			Role role = new Role();
			emp.setName("ragul");
			department.setId(1);
			emp.setDepartment(department);
			emp.setRole(role);
			role.setId(3);
			emp.setEmailId("ragul@gmail.com");
			emp.setPassword("ragul");
System.out.println(empService.registerService(emp));
UserSevice userService = new UserSevice();
System.out.println(userService.login(user));
//System.out.println(employeeService.login(emp));
}
	

}

//	System.out.println(us.registerService(u));




		
	


