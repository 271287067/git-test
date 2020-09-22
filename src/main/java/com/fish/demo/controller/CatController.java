package com.fish.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish.demo.bean.Cat;
import com.fish.demo.respository.Cat2Repository;
import com.fish.demo.service.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {

	@Resource
	private CatService catService;
	
	@RequestMapping("/save")
	public String save() {
		Cat cat = new Cat("jack", 3);
		catService.save(cat);
		return "save ok";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		catService.delete(1);
		return "delete ok";
	}
	
	@RequestMapping("/getAll")
	public Iterable<Cat> getAll(){
		return catService.getAll();
	}
	
	//自定义repository查询
	@RequestMapping("/findByCatName")
	public Cat findByCatName(String catName) {
		return catService.findByCatName(catName);
	}
	
	// JPQL语句查询
	@RequestMapping("/findMyCatName")
	public Cat findMyCatName(String catName) {
		return catService.findMyCatName(catName);
	}
	
	// JPQL
	@RequestMapping("/findMyCatAge")
	public Cat findMyCatAge(int catAge) {
		return catService.findMyCatAge(catAge);
	}

	@RequestMapping("/selectByCatName")
	public Cat selectByCatName(String catName) {
		return catService.selectByCatName(catName);
	}
	
	
}
