package com.employ.process.app.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employ.app.entity.LogIn;
import com.employ.process.app.repository.LoginRepo;


@Service
public class LogInService {

	private static final Logger LOG = Logger.getLogger(LogInService.class.getName());

	@Autowired
	private LoginRepo loginRepo;

	public boolean login(String user, String password) {

		LOG.info("User Name -------------> " + user);
		LOG.info("Password  -------------> " + password);
		//List<LogIn> logInList=loginRepo.findByUserNameAndPassword(user, password);
		int count = loginRepo.logIn(user, password);
		LOG.info("count  ----------------> " + count);
		if(count==1) {
			return true;
		}

		return false;
	}

	public LogIn loginDetails(String userId) {
		
//		LogIn login=loginRepo.LoginDetails(userName);
		
		LogIn login=loginRepo.getById(userId);
		return login;
	}

	public List<LogIn> getAllLogin() {
		List<LogIn> logInList = new ArrayList<>();
		logInList=loginRepo.findAll();
		return logInList;
	}

	public void saveUser(LogIn login) {

		login.setPassword(login.getPassword().substring(0,login.getPassword().indexOf(",")));
		login.setAccess("normal");
		loginRepo.save(login);
	};

}
