package com.zimug.boot.launch;

import com.zimug.boot.launch.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootLaunchApplication {

	LombokPOJO lombokPOJO = LombokPOJO.builder()
			.name("kobe")
			.age(39)
			.build();

	public static void main(String[] args) {
		SpringApplication.run(BootLaunchApplication.class, args);
	}

}
