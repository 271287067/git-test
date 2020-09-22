package com.fish;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 启动类
 * @author Administrator
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.**"})
public class App extends WebMvcConfigurerAdapter{
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		
		/**
		 * 1.需要先定义一个convert转换消息的对象
		 * 2.添加fastjson的配置信息，是否要格式化返回的json数据
		 * 3.在convert中添加配置信息
		 * 4.将convert添加到converters中
		 */
		
		// 1.需要先定义一个convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		
		// 2.添加fastjson的配置信息，是否要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.PrettyFormat
				);
		
		// 3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		
		// 4.将convert添加到converters中
		converters.add(fastConverter);
	}

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1.需要先定义一个convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		
		// 2.添加fastjson的配置信息，是否要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		// 3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		
		// 4.将convert添加到converters中
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
	
	
	public static void main(String[] args) {
		System.out.println("start...");

		SpringApplication.run(App.class, args);
		
	}
}
