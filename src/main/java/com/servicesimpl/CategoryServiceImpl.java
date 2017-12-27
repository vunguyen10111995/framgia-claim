package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.CategoryDao;
import com.entities.Category;
import com.servicesapi.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	
	public boolean saveOrUpdate(Category category) {
		return categoryDao.saveOrUpdate(category);
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryDao.list();
	}

	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.delete(category);
	}	
	
}