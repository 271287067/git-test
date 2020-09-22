package com.fish.demo.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fish.demo.bean.Cat;
import com.fish.demo.dao.CatDao;
import com.fish.demo.respository.Cat2Repository;
import com.fish.demo.respository.CatRepository;

@Service
public class CatService {

	@Resource
	private CatRepository catRepository;
	
	@Resource
	private Cat2Repository cat2Repository;
	
	@Resource
	private CatDao catDao;
	
	
	/**
	 * save，update，delete方法需要绑定事物
	 * 使用@Transactional进行事物的绑定
	 */
	
	// 保存数据
	@Transactional
	public void save(Cat cat) {
		catRepository.save(cat);
	}
	
	// 删除数据，参考Id
	@Transactional
	public void delete(int id) {
		catRepository.delete(id);
	}
	
	// 删除数据，参考实体字段
	@Transactional
	public void delete(Cat cat) {
		catRepository.delete(cat);
	}
	
	// 查询数据
	public Iterable<Cat> getAll() {
		return catRepository.findAll();
	}
	
	// 自定义repository查询
	public Cat findByCatName(String catName) {
		return cat2Repository.findByCatName(catName);
	}
	
	// JPQL语句查询
	public Cat findMyCatName(String catName) {
		return cat2Repository.findMyCatName(catName);
	}
	
	// JPQL语句查询
	public Cat findMyCatAge(int catAge) {
		return cat2Repository.findMyCatAge(catAge);
	}
	
	// jdbcTemplate查询
	public Cat selectByCatName(String catName) {
		return catDao.selectByCatName(catName);
	}
	
}
