package com.zimug.boot.launch.service;

import com.zimug.boot.launch.dao.testdb.ArticleRepository;
import com.zimug.boot.launch.dao.testdb.Article;
import com.zimug.boot.launch.model.ArticleVO;
import com.zimug.boot.launch.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service("articleRestJDBCServiceImpl")
public class ArticleRestJDBCServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	Mapper dozerMapper;

	@Override
	public void saveArticle(ArticleVO articleVO) {
		Article articlePO = dozerMapper.map(articleVO,Article.class);
		articleRepository.save(articlePO);
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
