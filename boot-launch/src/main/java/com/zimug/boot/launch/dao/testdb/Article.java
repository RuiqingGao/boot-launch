package com.zimug.boot.launch.dao.testdb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  id;

	@Column(nullable = false,length = 32)
	private String author;

	@Column(nullable = false, unique = true,length = 32)
	private String title;

	@Column(length = 512)
	private String content;
	private Date createTime;


}
