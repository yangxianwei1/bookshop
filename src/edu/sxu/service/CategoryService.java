package edu.sxu.service;

import java.util.List;

import edu.sxu.entity.Category;
/**
 *  将事物操作抽象到过滤层进行操作 
 * @author yangxianwei
 *
 */

public interface CategoryService {

	 
		void add(Category category);
		void update(Category category);
		Category findCategoryById(Integer id);
		void delete(Integer id);
		List<Category> findAll();

//		加上分页数据
		int rowCount();
		List<Category> queryByPage(int startLine, int size);
}
