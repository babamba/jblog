package com.bit2016.jblog.repository;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public Long insert(CategoryVo categoryVo){
		sqlSession.insert("category.insert", categoryVo);
		return categoryVo.getNo();
	}
	
	public CategoryVo getNo(Long no){
		return sqlSession.selectOne("category,getcategoryno", no);
	}
	
	
	
}
