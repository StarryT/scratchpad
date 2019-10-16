package com.starry.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午2:39:08
 * 
 * @Description TODO 
 *	日期时间处理
 */
public class TimeUtils {
	
	private TimeUtils() {
		
	}
	
	/**
	 * 	日期转化为字符串
	 * @param date
	 * @param dateFormat
	 * @return String
	 */
	public static String formatDateTime(Date date,String dateFormat) {
		if(ValueUtils.valNotEmpty(date)) {
			return new SimpleDateFormat(dateFormat).format(date);
		}
		return null;
	}
}
