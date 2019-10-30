package com.starry.dao.note;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.starry.bean.NoteBean;
import com.starry.utils.JdbcUtil;

/**
 * 
 * @copyright ：还没想好
 * 
 * @author starry
 * 
 * @version 1.0
 * 
 * @date 2019年10月28日 下午3:36:48
 * 
 * @Description TODO 根据id获取便签
 *
 */
public class GetNoteByIdDao {
	private QueryRunner runner;

	public GetNoteByIdDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}
	
	/**
	 * 根据id获取便签
	 * 
	 * @param id
	 * @return NoteBean
	 * @throws SQLException
	 */
	public NoteBean getNoteById(String id) throws SQLException {
		String sql="select* from note where id=?";
		return runner.query(sql,new BeanHandler<NoteBean>(NoteBean.class),new Object[] {id});
	}
	
	
}
