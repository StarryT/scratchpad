package com.starry.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午4:00:18
 * 
 * @Description TODO Jdbc 工具
 */
public class JdbcUtil {

	private JdbcUtil() {

	}

	private static DataSource ds;
	static {
		ds = new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
		return ds;
	}
}
