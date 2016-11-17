package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.controller.CategoryController;
import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public Long insertCategory(CategoryVo categoryVo){
		return categoryDao.insert(categoryVo);
	}
	
	public CategoryVo getNo(Long no){
		CategoryVo categoryVo = categoryDao.getNo(no);
		return categoryVo;
	}
}
