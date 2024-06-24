package edu.sxu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sxu.domain.PageBean;
import edu.sxu.entity.Category;
import edu.sxu.service.CategoryService;
import edu.sxu.service.impl.CategoryServiceImpl;
import edu.sxu.utils.WebUtils;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = new CategoryServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String method = request.getParameter("method");
		 System.out.println("method:"+method);
//		 System.out.println(method+"---->");
		 if("addCategory".equals(method)) {
			 doAddCategory(request,response);
		 }else if("queryCategory".equals(method)) {
			 doQueryCategory(request, response);
		 }     
		 
	}

	private void doQueryCategory(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		显示分页数据
//		用户不传的话   页数默认是第一页
		int currentPage = 1;
//		每页五条数据
		int size = 5;
		int rowCount = categoryService.rowCount();
		System.out.println(categoryService.queryByPage(0,5));
	 
		
		
		
	}

	private void doFindUI(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void doAddCategory(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		System.out.println("进来了.....");
//		System.out.println(request.getParameter("cname"));
//
//		System.out.println("hascode"+request.hashCode());
		Category category = WebUtils.request2Bean(request, Category.class);
		categoryService.add(category);
		
		
	}
  
}    
