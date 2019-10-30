package com.starry.dao.note;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
 * @date 2019年10月28日 下午3:27:27
 * 
 * @Description TODO 根据owner获取便签
 *
 */
public class GetAllNoteDao {
	private QueryRunner runner;

	public GetAllNoteDao() {
		runner = new QueryRunner(JdbcUtil.getDataSource());
	}

	/**
	 *获取所有的便签
	 * 
	 * @param owner
	 * @return
	 * @throws SQLException
	 */
	public List<NoteBean> getAllNote(String owner) throws SQLException {
		String sql = "select * from note where owner=?";
		return runner.query(sql,  new BeanListHandler<NoteBean>(NoteBean.class), new Object[] { owner });
	}
}
