package com.bit2016.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@RequestMapping("/{id}")
	public String index(@PathVariable(value="id")String id){
		System.out.println("@@@id  " + id);
		return "blog/blog-main";
	}
	
	
	
}
