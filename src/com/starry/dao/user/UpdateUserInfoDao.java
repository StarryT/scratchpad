package com.starry.dao.user;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.starry.bean.UserBean;
import com.starry.utils.JdbcUtil;

/**
 * 
 * @copyright ：还没想好
 * 
 * @author starry
 * 
 * @version 1.0
 * 
 * @date 2019年10月28日 下午1:05:25
 * 
 * @Description TODO
 *
 */
public class UpdateUserInfoDao {
	private QueryRunner runner;

	public UpdateUserInfoDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}

	/**
	 * 修改个人信息
	 * 
	 * @param userbean
	 * @throws SQLException
	 */
	public void getUserInfo(UserBean userbean) throws SQLException {
		String sql = "update user set nickname=?,gender=?,phone=?,email=? where username='" + userbean.getUsername()
				+ "'";
		runner.update(sql, new Object[] { userbean.getNickname(), userbean.getGender(), userbean.getPhone(),
				userbean.getEmail() });
	}
}
