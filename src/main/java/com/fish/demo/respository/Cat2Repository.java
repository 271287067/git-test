package com.fish.demo.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.fish.demo.bean.Cat;

public interface Cat2Repository extends Repository<Cat, Integer>{

	/**
	 * 查询方法以get，find，read开头
	 */
	
	// 根据catName进行查询
	public Cat findByCatName(String catName);

	
	/**
	 * 如何编写JPQL语句
	 * Hibernate	--HQL语句
	 * JPQL类似HQL语句
	 */
	@Query("from Cat where catName=:catName")
	public Cat findMyCatName(@Param("catName")String catName);
	
	@Query("from Cat where catAge = :age")
	public Cat findMyCatAge(@Param("age")int catAge);
	
}
