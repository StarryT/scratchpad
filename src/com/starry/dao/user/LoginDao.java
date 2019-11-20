package com.starry.dao.user;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.starry.bean.UserBean;
import com.starry.utils.JdbcUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月27日下午3:35:01
 * 
 * @Description TODO 登录接口 Dao
 */
public class LoginDao {

	private QueryRunner runner;

	public LoginDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}

	
	/**
	 * 根据用户名密码查找用户
	 * @param username
	 * @param password
	 * @return UserBean
	 * @throws SQLException
	 */
	public UserBean getUser(String username, String password) throws SQLException {
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		return runner.query(sql, new BeanHandler<UserBean>(UserBean.class), new Object[] { username, password });

	}

}
