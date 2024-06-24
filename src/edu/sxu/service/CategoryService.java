package edu.sxu.service;

import java.util.List;

import edu.sxu.entity.Category;
/**
 *  ������������󵽹��˲���в��� 
 * @author yangxianwei
 *
 */

public interface CategoryService {

	 
		void add(Category category);
		void update(Category category);
		Category findCategoryById(Integer id);
		void delete(Integer id);
		List<Category> findAll();

//		���Ϸ�ҳ����
		int rowCount();
		List<Category> queryByPage(int startLine, int size);
}
