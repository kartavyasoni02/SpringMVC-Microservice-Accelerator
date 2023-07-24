package com.yash.accelerator.validation;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yash.accelerator.controller.WebController;
import com.yash.accelerator.model.Employee;



@Component
public class UserFormValidator implements Validator {
	protected Logger logger = Logger.getLogger(WebController.class
			.getName());
	private static Pattern pattern;
	private static Matcher matcher;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	public boolean supports(Class<?> clazz)
	{
		return Employee.class.isAssignableFrom(clazz);
	}


	@Override
	public void validate(Object target, Errors errors) {
		logger.info("/****************** inside  Validator");
		Employee checkEmp = (Employee) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.error.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.error.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.error.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.error.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.error.password");
		Employee employee = (Employee) target;

		if(employee.getEmail()!=null && isValidate(employee.getEmail()) == false&& employee.getEmail().length()>0){
			errors.rejectValue("email", "NotEmpty.error.format.email", new Object[]{"'email'"}, "email can't be negative");
			logger.info("/****************** inside isValidate");
		} 
	}
	
	public static boolean isValidate(String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

}