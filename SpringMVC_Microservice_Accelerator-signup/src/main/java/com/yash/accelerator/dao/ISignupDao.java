package com.yash.accelerator.dao;

import java.util.List;

import com.yash.accelerator.model.Employee;

public interface ISignupDao extends GenericDao<Employee, Integer>{
	List<Employee> getEmployees(Integer employeeId) throws Exception;

}
