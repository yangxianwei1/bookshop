package edu.sxu.dao;

import java.util.List;

import edu.sxu.entity.Book; 

public interface BookDao {
	void add(Book book);
	void update(Book book);
	Book findBookById(Integer id);
	void delete(Integer id);
	List<Book> findAllBooks();
//	���Ϸ�ҳ����
	int rowCount();
	List<Book> queryByPage(int startLine, int size);
}
