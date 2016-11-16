package com.bit2016.jblog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;


@Service
public class UserService {

	
	@Autowired
	private UserDao userDao ;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao  categoryDao;
	
	
	public void join(UserVo userVo){
		Long userNo = userDao.insert(userVo);

		BlogVo blogVo = new BlogVo();
		
		blogVo.setNo(userNo);
		blogVo.setTitle(userVo.getId() + "님의 블로그");
		blogVo.setLogo("LOGO");
		
		CategoryVo categoryVo = new CategoryVo();
		
		categoryVo.setNo(userNo);
		
		
		
		
		blogDao.insert(blogVo);
		categoryDao.insert(categoryVo);
	}
	
	public UserVo login(String id, String password){
		return userDao.get(id, password);
	}
	

	
	public boolean idExists(String id){
		return userDao.get(id) != null;
	}
	
	
	
}
