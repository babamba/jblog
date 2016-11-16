package com.bit2016.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@RequestMapping("/main/{no}")
	public String index(@PathVariable("no")UserVo no, Model model){
		model.addAttribute("no", no);
		return "blog/blog-main";
	}
	
	
	
}
