package edu.sxu.utils;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
	
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz){
		
		T obj = null;
//		先把字节码文件的相关字段取出来
		 try {
		obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			field.setAccessible(true);
			Class<?> type = field.getType();
			String name = field.getName();
			String value = request.getParameter(name);
			if (type == String.class || type == Character.class) {
				field.set(obj, value);
			}else if(type == Integer.class || type == int.class) {
				field.set(obj, Integer.parseInt(value));
			}else if(type == Double.class || type == double.class) {
				field.set(obj, Double.parseDouble(value));
			}else if(type == Float.class || type == float.class) {
				field.set(obj, Float.parseFloat(value));
			}else if(type == Date.class) {
				SimpleDateFormat smp = new SimpleDateFormat("yyyy/MM/dd");
				field.set(obj, smp.parse(value));
			}
		}
		
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		 return null;
	}
} 
 