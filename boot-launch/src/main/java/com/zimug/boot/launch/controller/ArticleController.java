package com.zimug.boot.launch.controller;

import com.zimug.boot.launch.AjaxResponse;
import com.zimug.boot.launch.model.ArticleVO;
import com.zimug.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public AjaxResponse getArticle(@PathVariable Long id) {

		return AjaxResponse.success(articleService.getArticle(id));

	}

	@GetMapping( "/articles")
	public AjaxResponse getAllArticle() {
		List<ArticleVO> articles = articleService.getAll();
		return AjaxResponse.success(articles);

	}

	//增加一篇Article ，使用POST方法(RequestBody方式接收参数)ArticleRestControllerTest2
	//@RequestMapping(value = "/articles",method = RequestMethod.POST)
	@PostMapping("/articles")
	public AjaxResponse saveArticle(@RequestBody ArticleVO article){
		articleService.saveArticle(article);
		return AjaxResponse.success();
	}




	//更新一篇Article，使用PUT方法，以id为主键进行更新
	//@RequestMapping(value = "/articles",method = RequestMethod.PUT)
	@PutMapping("/articles")
	public AjaxResponse updateArticle(@RequestBody ArticleVO article){
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
