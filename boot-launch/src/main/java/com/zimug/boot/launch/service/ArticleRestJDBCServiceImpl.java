package com.zimug.boot.launch.service;

import com.zimug.boot.launch.dao.ArticleJDBCDAO;
import com.zimug.boot.launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service("articleRestJDBCServiceImpl")
public class ArticleRestJDBCServiceImpl implements ArticleService {

	@Autowired
	ArticleJDBCDAO articleJDBCDAO;

	//服务层一般还要写一些业务逻辑
	@Transactional
	@Override
	public Article saveArticle(Article article) {
		articleJDBCDAO.save(article);
		return article;
	}

	@Override
	public void deleteArticle(Long id) {
		articleJDBCDAO.deleteById(id);

	}

	@Override
	public void updateArticle(Article article) {
		articleJDBCDAO.updateById(article);

	}

	@Override
	public Article getArticle(Long id) {
		return articleJDBCDAO.findById(id);

	}

	@Override
	public List<Article> getAll() {
		return articleJDBCDAO.findAll();
	}
}
