package com.zimug.boot.launch;

import com.zimug.boot.launch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ArticleRestControllerTest2 {

	//mock对象
	@Resource
	private MockMvc mockMvc;

	//在所有测试方法执行之前进行mock对象初始化
//	@BeforeAll
//	static void setUp(){
//		// 针对ArticleController进行测试
//		mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//	}

	@Test
	public void saveArticle()throws Exception{

		String article = "{\"id\":1,\"author\":\"zimug\",\"title\":\"t1\",\"content\":\"spring boot 2.深入浅出\",\"createTime\":\"2020/07/15 09:46:03\",\"reader\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"kobe2\",\"age\":22}]}\n";

		//执行http请求
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders
						.request(HttpMethod.POST, "/rest/articles")
						.contentType("application/json")
						.content(article)
		)
		.andExpect(MockMvcResultMatchers.status().isOk())  //HTTP:status 200
		.andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(21))
		.andDo(print())
		.andReturn();

		result.getResponse().setCharacterEncoding("UTF-8");

		log.info(result.getResponse().getContentAsString());
	}



}
