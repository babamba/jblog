package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.PostVo;


public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	public Long insert(PostVo postVo){
		sqlSession.insert("post.insert", postVo);
		return postVo.getCategoryNo();
	}
		
}
