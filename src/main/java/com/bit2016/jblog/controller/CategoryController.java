package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2016.dto.JSONResult;
import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.AuthUser;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/blog/api/insert")
	public JSONResult insert(@RequestParam(value="name", required=true) String name,
							 @RequestParam(value="description", required=true) String description, 
							 @AuthUser UserVo userVo){
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName(name);
		categoryVo.setDescription(description);
		categoryVo.setUserNo(userVo.getNo());
	
		Long no = categoryService.insertCategory(categoryVo);
		CategoryVo categoryNo = categoryService.getNo(no);
		
		return JSONResult.success(categoryNo);
	
	}
}
