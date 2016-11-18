package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public JSONResult insert(@ModelAttribute CategoryVo categoryVo, 
							 @AuthUser UserVo userVo
			){
		//post방식으로 할때 데이터이름 맞춰주면 ModelAttribute vo 알아서 객체생성후 넣어준다.
		
		categoryVo.setUsersNo(userVo.getNo());
	
		System.out.println(categoryVo);
		Long no = categoryService.insertCategory(categoryVo);
		CategoryVo categoryNo = categoryService.getNo(no);
		
		return JSONResult.success(categoryNo);
	
	}
}
