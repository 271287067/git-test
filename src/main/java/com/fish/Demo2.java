package com.fish;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Demo2 {

	private int id;
	
	private String name;

	@JSONField(format="yyyy-MM-dd HH:mm")
	private Date createTime;
	
	public Demo2() {
		// TODO Auto-generated constructor stub
	}
	
	public Demo2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Demo2(int id, String name, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
