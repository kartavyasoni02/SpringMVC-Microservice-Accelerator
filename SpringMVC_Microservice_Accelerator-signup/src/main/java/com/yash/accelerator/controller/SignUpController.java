package com.yash.accelerator.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.accelerator.model.Employee;
import com.yash.accelerator.service.ISignupService;

/**
 * A RESTFul controller for accessing Signup Information.
 * 
 * @author kartavya.soni
 */
@RestController
public class SignUpController {
	protected Logger logger = Logger.getLogger(SignUpController.class
			.getName());
	
	@Autowired
	public ISignupService signupService; 
	
	@RequestMapping(value="/getEmployees",method=RequestMethod.GET)
	public List<Employee> getEmployees(@RequestParam(required=false) Integer employeeId){
		logger.info("In /getEmployee service");
		try {
			return signupService.getEmployee(employeeId);
		} catch (Exception e) {
			logger.info("error In /getEmployee service" );
		}
		return null;
	}
	//-------------------Create a User--------------------------------------------------------

	@RequestMapping(value = "/saveOrUpdateEmployee", method = RequestMethod.POST)
	public Integer saveOrUpdateEmployee(@RequestBody Employee employee) {
		logger.info("In /saveOrUpdateEmployee service");
		try {
			signupService.saveOrUpdateEmployee(employee);
			return 1;
		} catch (Exception e) {
			logger.info("error In /saveOrUpdateEmployee service" );
		}
		return 0;
	}
}
