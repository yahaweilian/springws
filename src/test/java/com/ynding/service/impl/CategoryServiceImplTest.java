package com.ynding.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ynding.entity.Category;
import com.ynding.service.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/applicationContext.xml"})
@EnableWebMvc
public class CategoryServiceImplTest {

	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Test
	public void testGetById() {
		
		Category category = categoryService.getById(1);
		assertEquals("1", category.getName());
		
	}

}
