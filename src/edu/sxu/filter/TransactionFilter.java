package edu.sxu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import edu.sxu.utils.JDBCUtils;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransactionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Connection con = JDBCUtils.getCon();
		try {
			con.setAutoCommit(false);
			System.out.println("拦截操作了  没发生异常....");
			chain.doFilter(request, response);
			System.out.println("操作允许执行了 没发生异常....");
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				System.out.println("发生异常了,事物回滚");
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
