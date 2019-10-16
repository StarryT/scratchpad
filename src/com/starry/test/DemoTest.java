package com.starry.test;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.starry.bean.NoteBean;
import com.starry.bean.UserBean;
import com.starry.dao.DemoDao;
import com.starry.utils.UUIDUtils;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午4:31:22
 * 
 * @Description TODO 
 *	DemoDao 测试，发布后删除
 */
public class DemoTest {
	
	
	
	/**
	 * 测试 addUser
	 * @throws SQLException 
	 */
	@Test
	public void addUser() throws SQLException {
		DemoDao demoDao = new DemoDao();
		UserBean userBean = new UserBean();
		userBean.setUsername("123");
		userBean.setPassword("123");
		userBean.setNickname("张三");
		userBean.setGender("0");
		userBean.setEmail("971896352@qq.com");
		userBean.setPhone("15502416971");
		demoDao.addUser(userBean);
	}
	
	/**
	 * 测试 getUserByUsername
	 * @throws SQLException 
	 */
	@Test
	public void getUserByUsername() throws SQLException {
		DemoDao demoDao = new DemoDao();
		System.out.println(demoDao.getUserByUsername("123"));
	}
	
	/**
	 * 测试 addNote
	 * @throws SQLException 
	 */
	@Test
	public void addNote() throws SQLException {
		DemoDao demoDao = new DemoDao();
		NoteBean noteBean = new NoteBean();
		noteBean.setId(UUIDUtils.getUUID());
		noteBean.setName("便签1");
		noteBean.setContent("便签一内容");
		noteBean.setOwner("123");
		demoDao.addNote(noteBean);
	}
	
	/**
	 * 测试 getNoteById
	 * @throws SQLException 
	 */
	@Test
	public void getNoteById() throws SQLException {
		DemoDao demoDao = new DemoDao();
		System.out.println(demoDao.getNoteById("6b7d1c71043f4e65bfc300b9572976c9"));
	}
	
	
}
