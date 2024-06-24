package edu.sxu.utils;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
	
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz){
		System.out.println("hascode"+request.hashCode());
		T obj = null;
//		�Ȱ��ֽ����ļ�������ֶ�ȡ����
		 try {
		obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(fields.length);
		for(Field field : fields) {
			field.setAccessible(true);
			Class<?> type = field.getType();
			String name = field.getName();
			String value = request.getParameter(name);
			System.out.println("name-->"+name+":::::"+"value---->"+value);
			System.out.println(type);
			System.out.println("--------------------");
			if(value == null) continue;
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
			System.out.println("webutil---��"+obj);
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
//		 return obj;
	}
} 
 