package edu.sxu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.sxu.dao.BookDao;
import edu.sxu.entity.Book;
import edu.sxu.entity.Category;
import edu.sxu.utils.JDBCUtils;

public class BookDaoImpl implements BookDao{

	public void add(Book book) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "insert into book values(null,?,?,?,?,?,?,?,?)";
		try {
			qr.update(JDBCUtils.getCon(),sql,book.getBname(),book.getAuthor(),book.getPrice(),//
					book.getBdesc(),book.getPublisher(),book.getBirth(),book.getPhoto(),book.getCategoryid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void update(Book book) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "update book set bname = ?,author = ?,price = ?, bdesc = ?,publisher = ?, birth = ?,photo=?,categoryid = ? where bid  = ?";
		try {
			qr.update(JDBCUtils.getCon(),sql,book.getBname(),book.getAuthor(),book.getPrice(),book.getBdesc(),//
					book.getPublisher(),book.getBirth(),book.getPhoto(),book.getCategoryid(),book.getBid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public Book findBookById(Integer id) {
		// TODO Auto-generated method stub
		Book res = null;
		QueryRunner qr = new QueryRunner();
		String sql = "select * from book where bid = ?";
		try {
			  res = qr.query(JDBCUtils.getCon(), sql,new BeanHandler<Book>(Book.class),id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return res; 
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 
		QueryRunner qr = new QueryRunner();
		String sql = "delete  from book where bid = ?";
		try {
//			  qr.query(JDBCUtils.getCon(), sql,new BeanHandler<Category>(Category.class),id);
			qr.update(JDBCUtils.getCon(), sql,id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		 
		
	}

	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		List<Book> rs = null;
		String sql = "select * from book";
		QueryRunner qr = new QueryRunner();
		try {
			  rs = qr.query(JDBCUtils.getCon(), sql,new BeanListHandler<Book>(Book.class));
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return rs;
		 
	}

	public int rowCount() {
		// TODO Auto-generated method stub
		String sql = "select count(1) from book";
		int count = 0;
		QueryRunner qr = new QueryRunner(); 
		try {
			count = qr.query(JDBCUtils.getCon(),sql, new ResultSetHandler<Integer>() {

				public Integer handle(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					if (rs.next()) {
						return rs.getInt(1);
					}
					return 0;
				}
				
			});
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public List<Book> queryByPage(int startLine, int size) {
		// TODO Auto-generated method stub
		List<Book> rs = null;
		String sql = "select * from book limit ?,?";
		QueryRunner qr = new QueryRunner();
		try {
			  rs = qr.query(JDBCUtils.getCon(), sql,new BeanListHandler<Book>(Book.class),startLine,size);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return rs;
	}
	}


