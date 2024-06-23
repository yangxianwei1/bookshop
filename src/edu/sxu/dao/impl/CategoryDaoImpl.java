package edu.sxu.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import edu.sxu.dao.CategoryDao;
import edu.sxu.entity.Category;
import edu.sxu.utils.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao{
	 
	public void add(Category category) {
		// TODO Auto-generated method stub
		QueryRunner qRunner = new QueryRunner();
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

	public Category findCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
