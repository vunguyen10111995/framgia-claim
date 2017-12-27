package com.servicesapi;

import java.util.List;

import com.entities.Category;

public interface CategoryService {
	public boolean saveOrUpdate(Category category);
	public List<Category> list();
	public boolean delete(Category category);
}
