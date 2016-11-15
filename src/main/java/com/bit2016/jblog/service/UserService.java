package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.UserVo;


@Service
public class UserService {

	
	@Autowired
	private UserDao userDao;
	
	public void join(UserVo vo){
		userDao.insert(vo);
	}
	
	public UserVo login(String id, String password){
		UserVo userVo = null;
		userDao.get(id, password);
		System.out.println("@@@@@@@@"+ id + password);
		return userVo;
	}
	
	
}
