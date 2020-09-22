package com.fish;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 在Thymeleaf模板文件中，所有的标签需要闭合
 * 在thymeleaf 3.0+之后不需要闭合
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/templates")
public class TemplatesController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/helloHtml")
	public String helloHtml(HttpServletRequest req, Map<String, Object> map) {
		System.out.println("结果: " + req.getAttribute("hello"));
		map.put("hello", "from templateController thymeleaf.");
		return "hello2";
	}
	
	@RequestMapping("/helloView")
	public ModelAndView helloView() {
		ModelAndView mav = new ModelAndView("hello");
		mav.addObject("hello", "from model and view");
		return mav;
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView("/templates/helloHtml");
		Map<String, Object> map = new HashMap<>();
		map.put("hello", "从内部一个方法跳转");
		mav.addAllObjects(map);
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String ftlHello(Map<String, Object> map) {
		map.put("hello", "from templateController freemarker.");
		return "hello3";
	}
	
}
