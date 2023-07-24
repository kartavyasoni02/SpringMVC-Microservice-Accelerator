package com.yash.accelerator.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.accelerator.model.Employee;
import com.yash.accelerator.service.ISigninService;

@RestController
public class SigninController {

	protected Logger logger = Logger.getLogger(SigninController.class
			.getName());

	@Autowired
	private	ISigninService signinService;

	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public Boolean checkSignIn(@RequestBody Employee employee) throws Exception{
		logger.info("in /signin service");
		return signinService.checkSignIn(employee.getUserName(),employee.getPassword()); 

	}
}
