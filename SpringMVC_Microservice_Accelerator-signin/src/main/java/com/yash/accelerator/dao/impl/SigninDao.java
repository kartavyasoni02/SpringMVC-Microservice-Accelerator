package com.yash.accelerator.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

import com.yash.accelerator.dao.GenericDaoImpl;
import com.yash.accelerator.dao.ISigninDao;
import com.yash.accelerator.model.Employee;

@Repository
public class SigninDao extends GenericDaoImpl<Employee, Integer>implements ISigninDao{
	protected Logger logger = Logger.getLogger(SigninDao.class
			.getName());
	@Override
	public Boolean checkSignIn(String userName, String password)throws Exception {
		logger.info("In SigninDao class and checkSignIn() method");
		@SuppressWarnings("unchecked")
		List<Employee>	users = (List<Employee>) currentSession().createQuery(
				" from Employee u where u.userName=:userName and u.password=:password ").setParameter("userName", userName)
				.setParameter("password", password).list();

		if(users!=null && !users.isEmpty()){
			return true;
		}
		return false;
	}
}