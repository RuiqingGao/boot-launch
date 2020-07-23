package com.zimug.boot.launch.controller;

import com.zimug.boot.launch.AjaxResponse;
import com.zimug.boot.launch.model.Article;
import com.zimug.boot.launch.model.Reader;
import com.zimug.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/rest")
public class ArticleController {
//	@Resource(name = "articleRestJDBCServiceImpl")
	@Autowired
//	@Resource
	ArticleService articleService;


	@GetMapping( "/articles/{id}")
	AjaxResponse getArticle(@PathVariable Long id) {

		return AjaxResponse.success(articleService.getArticle(id));

	}

	@GetMapping( "/articles")
	AjaxResponse getAllArticle() {

		return AjaxResponse.success(articleService.getAll());

	}

	//增加一篇Article ，使用POST方法(RequestBody方式接收参数)ArticleRestControllerTest2
	//@RequestMapping(value = "/articles",method = RequestMethod.POST)
	@PostMapping("/articles")
	public AjaxResponse saveArticle(@RequestBody Article article){

		return AjaxResponse.success(articleService.saveArticle(article));
	}




	//更新一篇Article，使用PUT方法，以id为主键进行更新
	//@RequestMapping(value = "/articles",method = RequestMethod.PUT)
	@PutMapping("/articles")
	public AjaxResponse updateArticle(@RequestBody Article article){
		if(article.getId() == null){
			//article.id是必传参数，因为通常根据id去修改数据
			//TODO 抛出一个自定义的异常
		}

		articleService.updateArticle(article);
		return AjaxResponse.success();
	}

	//删除一篇Article，使用DELETE方法，参数是id
	//@RequestMapping(value = "/articles/{id}",method = RequestMethod.DELETE)
	@DeleteMapping("/articles/{id}")
	public AjaxResponse deleteArticle(@PathVariable("id") Long id){

		articleService.deleteArticle(id);
		return AjaxResponse.success();
	}




}
