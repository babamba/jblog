package com.bit2016.jblog.repository;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void insert(BlogVo blogVo){
		sqlSession.insert("blog.bloginsert", blogVo);
		System.out.println("insert :" + blogVo);

	}
	
	public void update(BlogVo blogVo){
		sqlSession.update("blog.blogupdate", blogVo);
		System.out.println("update : " + blogVo);
	}
	
	public BlogVo getNo(Long no){
		return sqlSession.selectOne("getBlogNo", no);
	}
	
}
