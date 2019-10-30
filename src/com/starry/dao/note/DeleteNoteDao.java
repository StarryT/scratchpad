package com.starry.dao.note;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.starry.utils.JdbcUtil;

/**
 * 
 * @copyright ：还没想好
 * 
 * @author starry
 * 
 * @version 1.0
 * 
 * @date 2019年10月28日 下午2:51:59
 * 
 * @Description TODO
 *
 */
public class DeleteNoteDao {
	private QueryRunner runner;

	public DeleteNoteDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}
	
	/**
	 * 删除一个便签
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public void delNote(String id) throws SQLException {
		String sql = "delete from note where id=?";
		runner.update(sql, new Object[] { id });
	}
}
