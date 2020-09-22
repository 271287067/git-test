package com.fish;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * 使用@WebMvcTest和MockMvc搭配使用，可以在不启动web容器的情况下，对Controller进行测试
 * 注意：仅仅只是对controller进行简单的测试，如果Controller中依赖用@Autowired注入的service、dao等则不能这样测试。
 * 
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {HelloController.class})
public class ControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testHelloController() throws Exception {
		// groupManager访问路径
		// param传入参数
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/getList")
				.param("pageNum", "1")
				.param("pageSize", "10"))
				.andReturn();
		MockHttpServletResponse response = result.getResponse();
		String content = response.getContentAsString();
		System.out.println(content);
		// List<Demo> list = GsonUtils.toObjects(content, new
		// TypeToken<List<JtInfoDto>>() {}.getType());
		// for(JtInfoDto infoDto : jtInfoDtoList){
		// System.out.println(infoDto.getJtCode());
		// }
	}

}
