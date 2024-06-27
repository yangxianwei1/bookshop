package edu.sxu.servlet;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.cj.protocol.a.result.BinaryBufferRow;

import edu.sxu.entity.Book;
import edu.sxu.service.BookService;
import edu.sxu.service.impl.BookServiceImpl;
import edu.sxu.utils.WebUtils;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	统一锟斤拷锟叫凤拷锟斤拷
		String method = request.getParameter("method");
		if("add".equals(method)) {
			doAddBookAction(request,response);
		}
				
	
	}

	private void doAddBookAction(HttpServletRequest request, HttpServletResponse response)  {
		// TODO Auto-generated method stub
//		文件上传  只保存图片的名称 
//	
//		Book book = WebUtils.request2Bean(request, Book.class);
//		System.out.println(book);       
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Book book = null;
		try {
		if (upload.isMultipartContent(request)) {
			List<FileItem> parseRequest;
			parseRequest = upload.parseRequest(request);
			book = new Book();
			for(FileItem item : parseRequest) {
//				可能是普通text字段  也有可能是文件字段  当enctype盖面MIME类型时  它的分隔符会发生变化
				
				if (item.isFormField()) {
//						 
					String name = item.getFieldName();
					String value = item.getString();
					if ("bname".equals(name)) {
						book.setBname(value);
					}else if("author".equals(name)) {
						book.setAuthor(value);
					}else if("price".equals(name)) {
						book.setPrice(Double.parseDouble(value));
					}else if("bdesc".equals(name)) {
						book.setBdesc(value);
					}else if("publisher".equals(name)) {
						book.setPublisher(value);
					}else if("birth".equals(name)) {
						book.setBirth(new Date(value));
					}else if("categoryid".equals(name)) {
						book.setCategoryid(Integer.parseInt(value));
					}
					
				}else {
//					文件了
					String name = item.getName();
					book.setPhoto(name);
				 
//					把服务器传来的文件保存在当前 images目录下
//					System.out.println(">>>>>>>");
//					System.out.println(name);
//					System.out.println("<<<<<<<"); 
					InputStream inputStream = item.getInputStream();
					byte[] datas= new byte[1024];
					int len = 0;
					String path = request.getRealPath("/");
					String upLoadFN = path+"images\\"+name;
//					D:\tomact8.5\apache-tomcat-8.5.66\webapps\bookshop\
					System.out.println(">>>>>"+upLoadFN+"<<<");
					File file = new File(upLoadFN);
					file.createNewFile();
					OutputStream outputStream = new FileOutputStream(file);  
					while((len = inputStream.read(datas)) != -1 ) {
							outputStream.write(datas,0,len);
					}
					outputStream.close();
					inputStream.close();    
				}
			
				
			}
		}else {
			book = WebUtils.request2Bean(request, Book.class);
		} 
		bookService.add(book);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

}
	}
