package com.zimug.boot.launch.controller;

import com.zimug.boot.launch.AjaxResponse;
import com.zimug.boot.launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@Slf4j
@RequestMapping("/rest")
public class ArticleController {


	@GetMapping( "/articles/{id}")
	AjaxResponse getArticle(@PathVariable Long id) {

		Article article1 = Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").build();
		return AjaxResponse.success(article1);
	}

	//增加一篇Article ，使用POST方法(RequestBody方式接收参数)
	//@RequestMapping(value = "/articles",method = RequestMethod.POST)
	@PostMapping("/articles")
	public AjaxResponse saveArticle(@RequestBody Article article,@RequestHeader String aaa){

		//因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
		log.info("saveArticle:" + article);
		return AjaxResponse.success();
	}



//	@PostMapping("/articles")
//	public AjaxResponse saveArticle(@RequestParam String author,
//									@RequestParam String title,
//									@RequestParam String content,
//									@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//									@RequestParam Date createTime){
//
//		//因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
//		log.info("saveArticle:" + createTime);
//		return AjaxResponse.success();
//	}



	//更新一篇Article，使用PUT方法，以id为主键进行更新
	//@RequestMapping(value = "/articles",method = RequestMethod.PUT)
	@PutMapping("/articles")
	public AjaxResponse updateArticle(@RequestBody Article article){
		if(article.getId() == null){
			//article.id是必传参数，因为通常根据id去修改数据
			//TODO 抛出一个自定义的异常
		}

		log.info("updateArticle:" + article);
		return AjaxResponse.success();
	}

	//删除一篇Article，使用DELETE方法，参数是id
	//@RequestMapping(value = "/articles/{id}",method = RequestMethod.DELETE)
	@DeleteMapping("/articles/{id}")
	public AjaxResponse deleteArticle(@PathVariable("id") Long id){

		log.info("deleteArticle:" + id);
		return AjaxResponse.success();
	}




}
