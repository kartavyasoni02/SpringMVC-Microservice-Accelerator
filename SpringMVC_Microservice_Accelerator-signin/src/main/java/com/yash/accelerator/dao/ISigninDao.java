package com.yash.accelerator.dao;

import com.yash.accelerator.model.Employee;

public interface ISigninDao extends GenericDao<Employee, Integer>{
	public Boolean checkSignIn(String userName, String password)throws Exception;
}
