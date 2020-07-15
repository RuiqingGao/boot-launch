package com.zimug.boot.launch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zimug.boot.launch.model.Article;
import com.zimug.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ArticleRestControllerTest3 {

	//mock对象
	@Resource
	private MockMvc mockMvc;

	@MockBean //这个service还没有真正实现，所以加上注解mockbean
	private ArticleService articleService;

	//在所有测试方法执行之前进行mock对象初始化
//	@BeforeAll
//	static void setUp(){
//		// 针对ArticleController进行测试
//		mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//	}

	@Test
	public void saveArticle()throws Exception{

		String article = "{\"id\":1,\"author\":\"zimug\",\"title\":\"t1\",\"content\":\"spring boot 2.深入浅出\",\"createTime\":\"2020/07/15 09:46:03\",\"reader\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"kobe2\",\"age\":22}]}\n";

		ObjectMapper objectMapper = new ObjectMapper();
		Article articleObj = objectMapper.readValue(article,Article.class);

		//打桩
		when(articleService.saveArticle(articleObj)).thenReturn("ok");
		//当执行到articleService.saveArticle时，不去执行它内部的代码逻辑，而是返回一个ok

		//执行http请求
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders
						.request(HttpMethod.POST, "/rest/articles")
						.contentType("application/json")
						.content(article)
		).andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok"))
		.andDo(print())
		.andReturn();

		result.getResponse().setCharacterEncoding("UTF-8");

		log.info(result.getResponse().getContentAsString());
	}



}
