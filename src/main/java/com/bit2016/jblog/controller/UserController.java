package com.bit2016.jblog.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginform")
	public String login(){
		return "/user/login";
	}
	
	@RequestMapping("/joinform")
	public String joinform(@ModelAttribute UserVo userVo){
		return "/user/join";
	}
	
	@RequestMapping(value="/join")
	public String join(
			@ModelAttribute @Valid UserVo userVo,
			BindingResult result
			){
		if(result.hasErrors()){
			
			return "/user/joinform";
		}

		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess(){
		return "/user/joinsuccess";
	}
	
}
