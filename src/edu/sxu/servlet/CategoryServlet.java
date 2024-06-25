package edu.sxu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

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
		 if("addUI".equals(method)) {
			 doAddCategory(request,response);
		 }else if("findUI".equals(method)) {
//			 分页查询  用户没传数据 默认为第一页
			 doQueryCategory(request, response);
		 }else if("updateUI".equals(method)) {
			 doUpdateCategoryUI(request,response);
		 }else if("update".equals(method)) {
			 doUpdateCategory(request,response);
		 }else if("delete".equals(method)) {
			 doDeleteCategory(request,response);
		 }      
		  
	}

	private void doDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int cid =Integer.parseInt(request.getParameter("cid"));
		categoryService.delete(cid);
		Integer pid = (Integer) request.getSession(true).getAttribute("updatePageID");
		if (pid == null) {
			pid = 1;
		}
		response.sendRedirect("/bookshop/admin/category?method=findUI&pid="+pid);		
		
	}

	private void doUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Category newCate = WebUtils.request2Bean(request, Category.class);
		categoryService.update(newCate);
//		更新完之后  回到查看类型页面
		Integer pid = (Integer) request.getSession(true).getAttribute("updatePageID");
		if (pid == null) {
			pid = 1;
		}
		response.sendRedirect("/bookshop/admin/category?method=findUI&pid="+pid);		
	}

	private void doUpdateCategoryUI(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			int cid = Integer.parseInt(request.getParameter("cid"));	
			Category cate = categoryService.findCategoryById(cid);
			request.setAttribute("categoryud", cate);
			request.getRequestDispatcher("/admin/category/updateui.jsp").forward(request, response);
//			categoryService.update(cate);
//			先把用户的数据回显到页面当中
		} catch (Exception e) {         
			// TODO: handle exception
//			用户乱传的话就直接跳出....
			throw new RuntimeException(e+":input error!!");
		}
		
	}

	private void doQueryCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		显示分页数据
//		用户不传的话   页数默认是第一页
		
		int pid = 1;
		try {
			pid = Integer.parseInt(request.getParameter("pid"));
				
		} catch (Exception e) {
			// TODO: handle exception
			pid = 1;
		}
		int currentPage = pid;
		HttpSession session = request.getSession();
//		这个是为了 方便用户更新完数据后直接再次跳转到数据的所在页码
		session.setAttribute("updatePageID", pid);
		System.out.println("pid----->:"+pid);
//		每页五条数据
		int size = 5;
		int rowCount = categoryService.rowCount();
		PageBean<Category> page = new PageBean<Category>(currentPage, size, rowCount);
		page.setCurrentPage(currentPage);
		List<Category> datas = categoryService.queryByPage(page.getStartLine(), size);
		page.setDatas(datas);
//		
		System.out.println(page);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/category/findui.jsp").forward(request, response);
		
	 
		   
		   
		    
	}

	private void doFindUI(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void doAddCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println("进来了.....");
//		System.out.println(request.getParameter("cname"));
//
//		System.out.println("hascode"+request.hashCode());
		Category category = WebUtils.request2Bean(request, Category.class);
		categoryService.add(category);
//		添加完成之后跳转到类型分页首页
		response.sendRedirect("/bookshop/admin/category?method=findUI");
		
		
	}
  
}    
