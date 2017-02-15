package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.util.ValidatorUtil;

public class EmployeeValidator {
	
	
	public void  validateRegister(String name ,int deptId,int roleId,String email,String password) throws ValidatorException
	{
		ValidatorUtil validatorUtil = new ValidatorUtil();
validatorUtil.rejectIfNullOrEmpty(name, "name");
validatorUtil.rejectIfNegativeOrZeroOrNull(deptId, "dept_id");
validatorUtil.rejectIfNegativeOrZeroOrNull(roleId, "role_id");
validatorUtil.rejectIfNullOrEmpty(email, "email_id");
validatorUtil.rejectIfNullOrEmpty(password, "password");

			
	}

	public void validateLogin(String email,String password)throws ValidatorException{
		ValidatorUtil validatorUtil = new ValidatorUtil();
		validatorUtil.rejectIfNullOrEmpty(email, "email_id");
		validatorUtil.rejectIfNullOrEmpty(password, "password");
		
	}
	

}
