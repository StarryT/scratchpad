package com.starry.dao.note;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

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
 * @date 2019年10月28日 下午2:57:46
 * 
 * @Description TODO
 *
 */
public class UpdateNoteDao {
	private QueryRunner runner;

	public UpdateNoteDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}
	
	/**
	 * 更新便签
	 * 
	 * @param notebean
	 * @throws SQLException
	 */
	public void updateNote(NoteBean notebean) throws SQLException {
		String sql="update note set name=?,content=? where id=?";
		runner.update(sql, new Object[] {notebean.getName(),notebean.getContent(),notebean.getId()});
	}
}
