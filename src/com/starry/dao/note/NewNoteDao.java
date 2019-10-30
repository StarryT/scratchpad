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
 * @date 2019年10月28日 下午1:18:30
 * 
 * @Description TODO
 *
 */
public class NewNoteDao {
	private QueryRunner runner;

	public NewNoteDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}

	/**
	 * 创建一个便签
	 * 
	 * @param notebean
	 * @throws SQLException
	 */
	public void newNote(NoteBean notebean) throws SQLException {
		String sql = "insert into note(id,name,owner,content) value(?,?,?,?)";
		runner.update(sql,
				new Object[] { notebean.getId(), notebean.getName(), notebean.getOwner(), notebean.getContent() });
	}

}
