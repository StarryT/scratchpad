package com.starry.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.starry.bean.NoteBean;
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
 * @date 2019年10月16日下午4:10:10
 * 
 * @Description TODO 用于演示流程的 Dao，发布时删除
 */
public class DemoDao {

	private QueryRunner runner;

	public DemoDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}

	/**
	 * 新增一个用户
	 * 
	 * @param userBean
	 * @throws SQLException
	 */
	public void addUser(UserBean userBean) throws SQLException {
		String sql = "INSERT INTO user(username,password,nickname,gender,phone,email) VALUES(?,?,?,?,?,?)";
		runner.update(sql, new Object[] { userBean.getUsername(), userBean.getPassword(), userBean.getNickname(),
				userBean.getGender(), userBean.getPhone(), userBean.getEmail() });
	}

	/**
	 * 根据 username 获取用户
	 * 
	 * @param username
	 * @return UserBean
	 * @throws SQLException
	 */
	public UserBean getUserByUsername(String username) throws SQLException {
		String sql = "SELECT * FROM user WHERE username = ?";
		return runner.query(sql, new BeanHandler<UserBean>(UserBean.class), new Object[] { username });
	}

	/**
	 * 新增一个便签
	 * 
	 * @param userBean
	 * @throws SQLException
	 */
	public void addNote(NoteBean noteBean) throws SQLException {
		String sql = "INSERT INTO note(id,name,content,owner) VALUES(?,?,?,?)";
		runner.update(sql,
				new Object[] { noteBean.getId(), noteBean.getName(), noteBean.getContent(), noteBean.getOwner() });
	}

	/**
	 * 根据 id 获取便签
	 * 
	 * @param username
	 * @return UserBean
	 * @throws SQLException
	 */
	public NoteBean getNoteById(String id) throws SQLException {
		String sql = "SELECT * FROM note WHERE id = ?";
		return runner.query(sql, new BeanHandler<NoteBean>(NoteBean.class), new Object[] { id });
	}
	
	
}
