package com.yash.accelerator.service;

import java.util.List;

import com.yash.accelerator.model.Employee;

public interface ISignupService {
	public List<Employee> getEmployee(Integer employeeId) throws Exception;

	public Employee saveOrUpdateEmployee(Employee employee)throws Exception;

}
