package com.yash.accelerator.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.yash.accelerator.dao.GenericDaoImpl;
import com.yash.accelerator.dao.ISignupDao;
import com.yash.accelerator.model.Employee;

@Repository
public class SignupDao extends GenericDaoImpl<Employee, Integer>implements ISignupDao{
	protected Logger logger = Logger.getLogger(SignupDao.class
			.getName());
	public List<Employee> getEmployees(Integer employeeId)throws Exception {
		logger.info("In SignupDao class and getEmployees() method");
		StringBuilder queryString = new StringBuilder();
		queryString.append("from Employee");
		if(employeeId!=null && employeeId>0){
			queryString.append(" where id =:employeeId ");
		}
		Query q = currentSession().createQuery(queryString.toString());
		if(employeeId!=null && employeeId>0){
			q.setParameter("employeeId", employeeId);
		}
		q.setCacheable(true);
		q.setCacheRegion("employee");
		@SuppressWarnings("unchecked")
		List<Employee> list =  q.list();
		return list;
	}
}
