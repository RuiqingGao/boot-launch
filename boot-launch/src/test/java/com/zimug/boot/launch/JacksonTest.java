package com.zimug.boot.launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zimug.boot.launch.model.Article;
import com.zimug.boot.launch.model.Reader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {

	@Test
	void testJackson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		List<Reader> readers = new ArrayList<Reader>(){{
			add(new Reader("kobe",21));
			add(new Reader("kobe2",22));
		}};

		Article article1 = Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").reader(readers).build();
		String jsonstr = mapper.writeValueAsString(article1);

		System.out.println(jsonstr);

		Article article2 = mapper.readValue("{\"id\":1,\"author\":\"zimug\",\"title\":\"t1\",\"content\":\"spring boot 2.深入浅出\",\"createTime\":\"2020/07/15 09:46:03\",\"reader\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"kobe2\",\"age\":22}]}\n",Article.class);
		System.out.println(article2);

	}
}
