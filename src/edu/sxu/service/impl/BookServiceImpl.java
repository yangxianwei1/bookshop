package edu.sxu.service.impl;

import java.util.List;

import edu.sxu.dao.BookDao;
import edu.sxu.dao.impl.BookDaoImpl;
import edu.sxu.entity.Book;
import edu.sxu.service.BookService;

public class BookServiceImpl implements BookService{
	private BookDao bookDao = new BookDaoImpl();
	
	public void add(Book book) {
		// TODO Auto-generated method stub
		bookDao.add(book);
		
	}

	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
		
	}

	public Book findBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.findBookById(id);
//		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
		
	}

	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.findAllBooks();
	}

	public int rowCount() {
		// TODO Auto-generated method stub
		return bookDao.rowCount();
	}

	public List<Book> queryByPage(int startLine, int size) {
		// TODO Auto-generated method stub
		return bookDao.queryByPage(startLine, size);
	}

}
