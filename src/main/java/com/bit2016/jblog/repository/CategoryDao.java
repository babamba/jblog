package com.bit2016.jblog.repository;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.CategoryVo;
import com.sun.javafx.collections.MappingChange.Map;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public Long insert(CategoryVo categoryVo){
		System.out.println("cate insert");
		sqlSession.insert("category.insert", categoryVo);
		return categoryVo.getCategoryNo();
	}
	
	public CategoryVo getNo(Long no){
		System.out.println("cate getNO");
		return sqlSession.selectOne("category.getcategoryno", no);
	}
	
	public List<CategoryVo> getList(Long userNo){
		List<CategoryVo> list = sqlSession.selectList("category.getList", userNo);
		return list;
		
	}
	
}
