package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTests {
	
	@Autowired
	private Resouce resouce;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(resouce).isNotNull();	
	}
}
