package com.zimug.boot.launch.dao.testdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
	Article findByAuthor(String author);
}
