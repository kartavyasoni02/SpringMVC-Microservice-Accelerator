package com.yash.accelerator.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.yash.accelerator.dao.ISigninDao;
import com.yash.accelerator.service.ISigninService;

@Service
@EnableTransactionManagement
public class SigninService implements ISigninService {
	@Autowired
	ISigninDao signinDao; 

	@Override
	@Transactional
	public Boolean checkSignIn(String userName, String password) throws Exception {
		return signinDao.checkSignIn(userName, password);
	}
}
