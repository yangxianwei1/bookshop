package edu.sxu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.impl.NewPooledConnection;

import edu.sxu.dao.CategoryDao;
import edu.sxu.entity.Category;
import edu.sxu.utils.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao{
	public static void main(String[] args) {
		CategoryDao test = new CategoryDaoImpl();
		Category category = new Category();
		category.setCname("科技");
		category.setCdesc("科技相关类型的图书");
		
		System.out.println(test.findAll());
////		test.add(category);;
//		System.out.println(
//				test.findCategoryById(1));
	}
	 
	public void add(Category category) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "insert into category values(null,?,?)";
		try {
			qr.update(JDBCUtils.getCon(),sql,category.getCname(),category.getCdesc());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "update category set cname = ?,cdesc = ? where cid  = ?";
		try {
			qr.update(JDBCUtils.getCon(),sql,category.getCname(),//
					category.getCdesc(),category.getCid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public Category findCategoryById(Integer id) {
		// TODO Auto-generated method stub
		Category res = null;
		QueryRunner qr = new QueryRunner();
		String sql = "select * from category where cid = ?";
		try {
			  res = qr.query(JDBCUtils.getCon(), sql,new BeanHandler<Category>(Category.class),id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return res;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 
		QueryRunner qr = new QueryRunner();
		String sql = "delete  from category where cid = ?";
		try {
//			  qr.query(JDBCUtils.getCon(), sql,new BeanHandler<Category>(Category.class),id);
			qr.update(JDBCUtils.getCon(), sql);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		List<Category> rs = null;
		String sql = "select * from category";
		QueryRunner qr = new QueryRunner();
		try {
			  rs = qr.query(JDBCUtils.getCon(), sql,new BeanListHandler<Category>(Category.class));
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return rs;
	}

	public int rowCount() {
		// TODO Auto-generated method stub
		String sql = "select count(1) from category";
		int count = 0;
		QueryRunner qr = new QueryRunner(); 
		try {
			count = qr.query(JDBCUtils.getCon(),sql, new BeanHandler<Integer>(Integer.class));
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		 
	}

	public List<Category> queryByPage(int startLine, int size) {
		// TODO Auto-generated method stub
		List<Category> rs = null;
		String sql = "select * from category limit ?,?";
		QueryRunner qr = new QueryRunner();
		try {
			  rs = qr.query(JDBCUtils.getCon(), sql,new BeanListHandler<Category>(Category.class),startLine,size);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return rs;
	}

}
