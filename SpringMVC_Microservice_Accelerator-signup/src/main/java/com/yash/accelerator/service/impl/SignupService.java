package com.yash.accelerator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.accelerator.dao.ISignupDao;
import com.yash.accelerator.model.Employee;
import com.yash.accelerator.service.ISignupService;

@Service
@Transactional
public class SignupService implements ISignupService{
	@Autowired
	ISignupDao signupDao;
	@Transactional
	public List<Employee> getEmployee(Integer employeeId) throws Exception{
		return 	signupDao.getEmployees(employeeId);
	}
	@Transactional
	public Employee saveOrUpdateEmployee(Employee employee) throws Exception {
		if(employee.getId()!=null){
			Employee emp = signupDao.find(employee.getId());
			signupDao.saveOrUpdate(emp);
		}else{
			signupDao.saveOrUpdate(employee);
		}
		return employee;
	}
}
