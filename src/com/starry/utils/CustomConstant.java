package com.starry.utils;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午2:20:49
 * 
 * @Description TODO 
 *	常量类
 */
public class CustomConstant {
	private CustomConstant() {
		
	}
	
	/**
	 * 
	 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
	 * 
	 * @author 16计算机弓耀
	 * 
	 * @version 1.0
	 * 
	 * @date 2019年10月16日下午2:27:51
	 * 
	 * @Description TODO 
	 *	通用常量
	 *	使用方法：CustomConstant.Custom.UTF8
	 */
	public static final class Custom {
		private Custom() {
			
		}
		
		/** UTF-8 */
		public static final String UTF8 = "UTF-8";
		/** session 中的存储用户信息键 */
		public static final String SESSION_LOGIN_MARK = "loginMark";
	}
	
	
	/**
	 * 
	 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
	 * 
	 * @author 16计算机弓耀
	 * 
	 * @version 1.0
	 * 
	 * @date 2019年10月16日下午2:25:40
	 * 
	 * @Description TODO 
	 *	日期格式
	 *	使用方法 CustomConstant.DateType.DATE_TYPE_01
	 */
	public static final class DateType{
		private DateType() {
			
		}
		
		/** 日期格式：yyyy-MM-dd HH:mm:ss */
		public static final String DATE_TYPE_01 = "yyyy-MM-dd HH:mm:ss";
		/** 日期格式：yyyy-MM-dd */
		public static final String DATE_TYPE_02 = "yyyy-MM-dd";
		/** 日期格式：HH:mm:ss */
		public static final String DATE_TYPE_03 = "HH:mm:ss";
	}
	
	
	/**
	 * 
	 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
	 * 
	 * @author 16计算机弓耀
	 * 
	 * @version 1.0
	 * 
	 * @date 2019年10月16日下午2:34:38
	 * 
	 * @Description TODO 
	 *	常用 content 消息头
	 *	使用方法 CustomConstant.ResponseHeader.APPLICATION_JSON
	 */
	public static final class ResponseHeader{
		private ResponseHeader() {
			
		}
		
		/** APPLICATION_JSON 常量定义 */
		public static final String APPLICATION_JSON = "application/json;charset=UTF-8";
	}
	
}
