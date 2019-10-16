package com.starry.utils;

import java.util.UUID;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午3:57:11
 * 
 * @Description TODO UUID 工具
 */
public class UUIDUtils {
	private UUIDUtils() {

	}

	/**
	 * 	获取 32 位无 “-” 的 UUID 
	 * @return String
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
