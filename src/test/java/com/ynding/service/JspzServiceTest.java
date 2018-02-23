package com.ynding.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ynding.entity.Jspz;
import com.ynding.exception.DbOprationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/applicationContext.xml"})
@EnableWebMvc
public class JspzServiceTest {

	@Autowired
	JspzService jspzService;
	
	@Test
	public void testGetQyList() throws DbOprationException {
		List<Jspz> jspzs = jspzService.getQyList();
		assertNotNull(jspzs);
	}

	@Test
	public void testGetBYJmxzdm() throws DbOprationException {
		String yhdm = "";
		Jspz jspz = jspzService.getBYJmxzdm(yhdm);
		assertNotNull(jspz);
	}

}
