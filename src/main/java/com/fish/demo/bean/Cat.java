package com.fish.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 创建实体类
 * 如何持久化
 * 使用注解@Entity，当JPA检测时
 * @author Administrator
 *
 */

@Entity
public class Cat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String catName;
	
	private int catAge;

	public Cat() {
		// TODO Auto-generated constructor stub
	}
	
	public Cat(String catName, int catAge) {
		super();
		this.catName = catName;
		this.catAge = catAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getCatAge() {
		return catAge;
	}

	public void setCatAge(int catAge) {
		this.catAge = catAge;
	}
	
}
