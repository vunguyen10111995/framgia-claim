package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoapi.CategoryDao;
import com.entities.Category;


@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Category category) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	public List<Category> list() {
		return session.getCurrentSession().createQuery("from Category").list();
	}

	public boolean delete(Category category) {
		try{
			session.getCurrentSession().delete(category);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
}
