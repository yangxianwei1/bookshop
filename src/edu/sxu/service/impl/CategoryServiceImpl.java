package edu.sxu.service.impl;

import java.util.List;

import edu.sxu.dao.CategoryDao;
import edu.sxu.dao.impl.CategoryDaoImpl;
import edu.sxu.entity.Category;
import edu.sxu.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImpl();
	public static void main(String[] args) {
		CategoryDao categoryDao = new CategoryDaoImpl();
		
		System.out.println(categoryDao.queryByPage(0, 5));
	}
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryDao.add(category);
		
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryDao.update(category);
	}

	public Category findCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return categoryDao.findCategoryById(id);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		categoryDao.delete(id);
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	public int rowCount() {
		// TODO Auto-generated method stub
		return categoryDao.rowCount();
	}

	public List<Category> queryByPage(int startLine, int size) {
		// TODO Auto-generated method stub
		return categoryDao.queryByPage(startLine, size);
	}

}
