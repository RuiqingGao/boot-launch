package com.zimug.boot.launch.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Data
@Component
@ConfigurationProperties(prefix = "family")
@Validated
public class Family {

	@NotEmpty
	private String familyName;   //成员变量名称要和yml配置项key一一对应
	private Father father;
	private Mother mother;
	private Child child;

}