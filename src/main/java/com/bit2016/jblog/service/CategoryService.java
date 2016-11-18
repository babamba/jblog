package com.bit2016.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<CategoryVo> getList(Long no){
		return categoryDao.getList(no);
	}
	
}
