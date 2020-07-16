package com.zimug.boot.launch.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "family")
public class Family {

	private String familyName;   //成员变量名称要和yml配置项key一一对应
	private Father father;
	private Mother mother;
	private Child child;

}