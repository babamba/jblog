package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
@RequestMapping("/{id}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String index(Model model,@ModelAttribute BlogVo blogVo, @PathVariable(value="id") String id){
		
	
		model.addAttribute("blogVo", blogService.getBlogNo(userService.getId(id).getNo()));	
		System.out.println(blogVo);
		return "blog/blog-main";
	}
	
	@RequestMapping("/admin/basic")
	public String adminform(@PathVariable(value="id")String id){
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/admin/category")
	public String categoryform(@PathVariable(value="id")String id){
		return "blog/blog-admin-category";
	}
	
	@RequestMapping("/admin/write")
	public String postform(@PathVariable(value="id")String id){
		return "blog/blog-admin-write";
	}
	
	@Auth
	@RequestMapping(value="/basicupdate", method=RequestMethod.POST)
	public String basicUpdate(
			@AuthUser UserVo userVo,
			@ModelAttribute BlogVo blogVo,
			@RequestParam("logo-file")MultipartFile multipartFile,
			@PathVariable(value="id")String id
			){
		blogService.restore(blogVo, multipartFile, userVo);
		System.out.println("controller"+ blogVo);
		
		return "redirect:/" + id;
	}
	
	
	
}
