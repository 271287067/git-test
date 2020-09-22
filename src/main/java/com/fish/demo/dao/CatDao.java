package com.fish.demo.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fish.demo.bean.Cat;

@Repository
public class CatDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 1.定义SQL
	 * 2.定义ROWMapper
	 * 3.执行查询
	 * @return
	 */
	public Cat selectByCatName(String catName) {
		String sql = "select * from cat where cat_name = ?";
		RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<>(Cat.class);
		Cat cat = jdbcTemplate.queryForObject(sql, new Object[] {catName}, rowMapper);
		return cat;
	}
	
}
