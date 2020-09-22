package com.fish;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fish.demo.bean.Cat;
import com.fish.demo.service.CatService;

/**
 * @RunWith是Junit4提供的注解，将Spring和Junit链接了起来。
 * 假如使用Junit5，不再需要使用@ExtendWith注解，@SpringBootTest和其它@*Test默认已经包含了该注解。
 * 
 * 由于web服务是最常见的服务，且我们对于web服务的测试有一些特殊的期望，所以@SpringBootTest注解中，
 * 给出了webEnvironment参数指定了web的environment，该参数的值一共有四个可选值：MOCK，RANDOM_PORT，DEFINED_PORT，NONE
 * MOCK：此值为默认值，该类型提供一个mock环境，可以和@AutoConfigureMockMvc或@AutoConfigureWebTestClient搭配使用，
 * 开启Mock相关的功能。注意此时内嵌的服务（servlet容器）并没有真正启动，也不会监听web服务端口。
 * RANDOM_PORT：启动一个真实的web服务，监听一个随机端口。
 * DEFINED_PORT：启动一个真实的web服务，监听一个定义好的端口（从application.properties读取）。
 * NONE：启动一个非web的ApplicationContext，既不提供mock环境，也不提供真实的web服务。
 * 注：如果当前服务的classpath中没有包含web相关的依赖，spring将启动一个非web的ApplicationContext，此时的webEnvironment就没有什么意义了。
 * 
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringConfigTest {

	
	@LocalServerPort
	private int port;
	
	private URL base;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private CatService catService;
	
	
	@Before
	public void setUp() throws MalformedURLException {
		String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
	}
	
	@Test
	public void testSave() {
		catService.save(new Cat("hery", 5));
	}
	
	@Test
	public void test() {
		System.out.println(this.restTemplate);
		 ResponseEntity<List> response = this.restTemplate.getForEntity(
				this.base.toString() + "/cat/getAll", List.class, "");
		System.out.println(response.getBody());
	}
	
	
}
