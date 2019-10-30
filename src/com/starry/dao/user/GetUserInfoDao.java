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
 * @date 2019年10月27日下午4:24:53
 * 
 * @Description TODO 获取个人信息接口 Dao
 */
public class GetUserInfoDao {
	private QueryRunner runner;

	public GetUserInfoDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param username
	 * @return UserBean
	 * @throws SQLException
	 */
	public UserBean getUserByUsername(String username) throws SQLException {
		String sql = "SELECT * FROM user WHERE username = ?";
		return runner.query(sql, new BeanHandler<UserBean>(UserBean.class), new Object[] { username });
	}
}
