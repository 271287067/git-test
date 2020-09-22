package com.fish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 说明@restController相当于@Controller和@responseBody
 * @author Administrator
 *
 */
@RestController
public class HelloController {

	/**
	 * 使用http://127.0.0.1:8080/hello
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	/**
	 * spring boot默认使用的json解析框架是jackson
	 * @return
	 */
	@RequestMapping("/getDemo")
	public Demo getDemo() {
		Demo d = new Demo(1, "张三", new Date());
		return d;
	}
	
	@RequestMapping("/testDeploy")
	public String testDepoy() {
		return "testDeploy";
	}
	
	@RequestMapping("/getList")
	public List<Demo> getList(HttpServletRequest req){
		List<Demo> list = new ArrayList<Demo>();
		list.add(new Demo(2, "李四", new Date()));
		list.add(new Demo(3, "王五", new Date()));
		list.add(new Demo(4, "赵六", new Date()));
		return list;
	}
}
