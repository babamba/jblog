package com.bit2016.jblog.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.dto.JSONResult;
import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.AuthUser;

@Controller("categoryAPIController")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping("/{id}/blog/api/insert")
	public JSONResult insert(@PathVariable(value = "id") String id,
			@ModelAttribute CategoryVo categoryVo, @AuthUser UserVo userVo) {
		// post방식으로 할때 데이터이름 맞춰주면 ModelAttribute vo 알아서 객체생성후 넣어준다.

		categoryVo.setUsersNo(userVo.getNo());
		System.out.println(categoryVo);
		Long no = categoryService.insertCategory(categoryVo);
		CategoryVo categoryNo = categoryService.getNo(no);

		return JSONResult.success(categoryNo);

	}

	@ResponseBody
	// 알아보기
	@RequestMapping("/admin/category")
	public JSONResult list(
			@AuthUser UserVo userVo) {
		System.out.println("ff");
		System.out.println(userVo.getNo());

		List<CategoryVo> list = categoryService.getList(userVo.getNo());

		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
		return JSONResult.success(list);
	}
	
	
	@RequestMapping("/{id}/admin/category")
	public String main(
			@ModelAttribute CategoryVo CategoryVo,
			@PathVariable(value = "id") String id,
			@AuthUser UserVo userVo,
			Model model) {
		System.out.println("ff");
		System.out.println(userVo.getNo());

		List<CategoryVo> list = categoryService.getList(userVo.getNo());

		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
		return "blog/blog-admin-category";
	}

}