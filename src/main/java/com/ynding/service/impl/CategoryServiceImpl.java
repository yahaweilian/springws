package com.ynding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynding.dao.CategoryDao;
import com.ynding.entity.Category;
import com.ynding.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Category getById(int id) {
		
		return categoryDao.get(id);
	}

}
