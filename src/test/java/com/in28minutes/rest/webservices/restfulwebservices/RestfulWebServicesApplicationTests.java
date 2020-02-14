package com.in28minutes.rest.webservices.restfulwebservices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RestfulWebServicesApplication.class)
@RunWith(SpringRunner.class)
public class RestfulWebServicesApplicationTests {

	@Test
	public void contextLoads() {
		String[] args={"hi"};
		RestfulWebServicesApplication.main(args);
	}

}
