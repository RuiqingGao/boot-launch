package com.zimug.boot.launch.service;

import com.zimug.boot.launch.dao.testdb.ArticleRepository;
import com.zimug.boot.launch.dao.testdb.Article;
import com.zimug.boot.launch.dao.testdb2.Message;
import com.zimug.boot.launch.dao.testdb2.MessageRepository;
import com.zimug.boot.launch.model.ArticleVO;
import com.zimug.boot.launch.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service("articleRestJDBCServiceImpl")
public class ArticleRestJDBCServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	MessageRepository messageRepository;

	@Autowired
	Mapper dozerMapper;

	@Override
	@Transactional
	public void saveArticle(ArticleVO article) {
		Article articlePO = dozerMapper.map(article,Article.class);
		articleRepository.save(articlePO);
		messageRepository.save(new Message(null,"zimug22","爱学习"));
		//int a= 2/0;

	}

	@Override
	public void deleteArticle(Long id) {
		articleRepository.deleteById(id);

	}

	@Override
	public void updateArticle(ArticleVO articleVO) {
		Article articlePO = dozerMapper.map(articleVO, Article.class);
		articleRepository.save(articlePO);
	}

	@Override
	public ArticleVO getArticle(Long id) {
		Optional<Article> article = articleRepository.findById(id);
		return dozerMapper.map(article.get(), ArticleVO.class);
	}

	@Override
	public List<ArticleVO> getAll() {
		List<Article> articleLis = articleRepository.findAll();
		//查询article表的所有数据
		return DozerUtils.mapList(articleLis,ArticleVO.class);
	}
}
