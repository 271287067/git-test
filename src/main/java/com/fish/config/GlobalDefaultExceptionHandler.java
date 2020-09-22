package com.fish.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1.类添加注解，@ControllerAdvice
 * 2.类中的方法添加@ExceptionHandler拦截相应的异常信息
 * 3.如果返回是view--方法，则返回值是ModelAndView
 * 4.如果返回是String或Json数据，则需要在方法上添加@@ResponseBody注解
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String defaultErrorHandler(HttpServletRequest req, Exception e) {
		// 返回的String
		return "对不起，服务器繁忙!";
	}
	
}
