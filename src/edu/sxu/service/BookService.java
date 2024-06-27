package edu.sxu.service;

import java.util.List;

import edu.sxu.entity.Book;


public interface BookService {
	void add(Book book);
	void update(Book book);
	Book findBookById(Integer id);
	void delete(Integer id);
	List<Book> findAllBooks();

//	���Ϸ�ҳ����
	int rowCount();
	List<Book> queryByPage(int startLine, int size);
}
