package com.bit2016.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/post")
public class PostController {

	@RequestMapping()
	public String post(){
		return"";
	}
}
