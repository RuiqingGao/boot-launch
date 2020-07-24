package com.zimug.boot.launch.service;

import com.zimug.boot.launch.dao.ArticleJDBCDAO;
import com.zimug.boot.launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service("articleRestJDBCServiceImpl")
public class ArticleRestJDBCServiceImpl implements ArticleService {

	@Autowired
	ArticleJDBCDAO articleJDBCDAO;

	@Resource
	private JdbcTemplate primaryJdbcTemplate;
	@Resource
	private JdbcTemplate secondaryJdbcTemplate;

	//服务层一般还要写一些业务逻辑
	@Transactional
	@Override
	public Article saveArticle(Article article) {
		articleJDBCDAO.save(article,primaryJdbcTemplate);
		articleJDBCDAO.save(article,secondaryJdbcTemplate);
//		int a = 2/0;    //人为制造一个被除数为0的异常，发现其中一个数据库中存入了数据，但是另一个数据库中没有存入数据。
		return article;
	}

	@Override
	public void deleteArticle(Long id) {
		articleJDBCDAO.deleteById(id,null);

	}

	@Override
	public void updateArticle(Article article) {
		articleJDBCDAO.updateById(article,null);

	}

	@Override
	public Article getArticle(Long id) {
		return articleJDBCDAO.findById(id,null);

	}

	@Override
	public List<Article> getAll() {
		return articleJDBCDAO.findAll(null);
	}
}
