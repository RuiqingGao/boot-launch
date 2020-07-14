package com.zimug.boot.launch.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Article {
	private Long  id;
	private String author;
	private String title;
	private String content;
	private Date createTime;

	private List<Reader> reader;
}