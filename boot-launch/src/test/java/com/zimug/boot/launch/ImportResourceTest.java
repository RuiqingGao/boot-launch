package com.zimug.boot.launch;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)  //Junit5
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ImportResourceTest {
	@Autowired
	private ConfigurableApplicationContext ioc;

	@Test
	public void testImport() throws Exception{
		boolean isImport = ioc.containsBean("testBeanService");
		System.out.println(isImport);
	}
}
