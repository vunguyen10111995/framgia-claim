package com.daoapi;

import java.util.List;

import com.entities.Category;

public interface CategoryDao {
	public boolean saveOrUpdate(Category category);
	public List<Category> list();
	public boolean delete(Category category);
}
