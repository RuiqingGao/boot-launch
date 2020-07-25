package com.zimug.boot.launch.dao;

import com.zimug.boot.launch.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
	Article findByAuthor(String author);
}
