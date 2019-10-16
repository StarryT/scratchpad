package com.starry.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午2:42:22
 * 
 * @Description TODO 值工具
 */
public class ValueUtils {
	private ValueUtils() {

	}

	/**
	 * 输入流转化为 String
	 * 
	 * @param InputStream
	 * @return String
	 */
	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 	判断值是否为不为空
	 * @param Object
	 * @return boolean
	 */
	public static boolean valNotEmpty(Object obj) {
		boolean b = true;
		if(obj == null) {
			b = false;
		}else if(obj instanceof CharSequence) {
			if(((CharSequence) obj).length() == 0) {
				b = false;
			}
		}else if(obj instanceof Map) {
			if(((Map<?,?>) obj).isEmpty()) {
				b = false;
			}
		}else if(obj instanceof String) {
			if("".equals((String)obj) || "null".equals((String)obj)) {
				b = false;
			}
		}else if(obj instanceof Object[]) {
			Object[] objs = (Object[])obj;
			if(objs.length == 0) {
				b = false;
			}else {
				boolean empty = false;
				for(int i = 0; i < objs.length; i++) {
					if(valNotEmpty(objs[i])) {
						empty = true;
						break;
					}
				}
				b = empty;
			}
		}
		return b;
	}
	
	/**
	 * 	判断值是否为空
	 * @param Object
	 * @return boolean
	 */
	public static boolean valEmpty(Object obj) {
		return !valNotEmpty(obj);
	}
	
	/**
	 * 	判断字符串是否为整数
	 * @param String
	 * @return boolean
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * 	判断字符串是否为浮点数
	 * @param String
	 * @return boolean
	 */
	public static boolean isDigital(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * 	判断字符串是否为目录
	 * @param String
	 * @return boolean
	 */
	public static boolean isValidDirectory(String path) {
		File file = new File(path);
		if(file.isDirectory()) {
			return true;
		}
		return false;
	}
	

}
