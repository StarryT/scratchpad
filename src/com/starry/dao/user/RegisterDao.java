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
 * @date 2019年10月28日 上午9:24:39
 * 
 * @Description TODO
 *
 */
public class RegisterDao {
	private QueryRunner runner;

	public RegisterDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}

	/**
	 * 用户注册
	 * 
	 * @param userbean
	 * @throws SQLException
	 */
	public void register(UserBean userbean) throws SQLException {
		String sql = "insert into user(username, password, nickname, gender, phone, email) value(?,?,?,?,?,?)";
		runner.update(sql, new Object[] { userbean.getUsername(), userbean.getPassword(), userbean.getNickname(),
				userbean.getGender(), userbean.getPhone(), userbean.getEmail() });
	}
}
