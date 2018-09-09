package com.dept.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DepartmentServiceApplicationTests {

	
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Test
	public void contextLoads() {
		
		
	}
	
	@Test
	public void testConnection() {
		
		ResponseEntity<List> dept = this.restTemplate.getForEntity("http://localhost:8091/departmentdetails/departments", List.class);
		assertEquals(dept.getStatusCodeValue(), 200);
		
	}
	
	
	
	
	
	
	
	
		
	

}
