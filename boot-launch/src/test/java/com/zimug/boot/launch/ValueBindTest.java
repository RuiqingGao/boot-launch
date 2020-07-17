package com.zimug.boot.launch;


import com.zimug.boot.launch.model.Employee;
import com.zimug.boot.launch.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)  //Junit5
@SpringBootTest
public class ValueBindTest {
	@Autowired
	Family family;

	@Resource
	Employee employee;
	@Test
	public void hello(){
		System.out.println(family.toString());
	}

	@Test
	public void valueBindTests2() throws Exception {
		System.out.println(employee.toString());
	}
}
