package edu.sxu.dao;

import java.util.List;

import edu.sxu.entity.Category;

/**
 * 
 * @author yangxianwei
 *  Category  CRUD
 */
public interface CategoryDao {
	 
	void add(Category category);
	void update(Category category);
	Category findCategoryById(Integer id);
	void delete(Integer id);
	List<Category> findAll();
	

}
