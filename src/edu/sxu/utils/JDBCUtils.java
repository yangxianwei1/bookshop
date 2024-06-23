package edu.sxu.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource; 
public class JDBCUtils {

	private static DataSource ds = null;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	static {
		ds = new ComboPooledDataSource();
	}
 
	public static Connection getCon() {
		Connection connection = tl.get();
		if(connection == null) {
			try {
				connection = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			tl.set(connection);
		}
		return connection;
	}
	
	public void free(Connection con, PreparedStatement pst, ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
 
}
