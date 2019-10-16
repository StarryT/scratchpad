package com.starry.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.bean.NoteBean;
import com.starry.dao.DemoDao;
import com.starry.utils.UUIDUtils;
import com.starry.utils.ValueUtils;
import com.starry.utils.WrapParamUtils;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午5:29:01
 * 
 * @Description TODO 
 *	用于演示流程的 Servlet，发布时删除
 */
@WebServlet("/demoNote")
public class DemoNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DemoNoteServlet() {
        super();
    }

	
    /**
	 * 新增便签
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			// 获取参数
			Map<String, Object> params = WrapParamUtils.paramToMap(request);

			// 参数校验
			if (ValueUtils.valEmpty(params.get("name"))) {
				result = "name 不能为空";
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(params.get("content"))) {
				result = "content 不能为空";
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(params.get("owner"))) {
				result = "owner 不能为空";
				response.getWriter().write(result);
				return;
			}
			

			// NoteBean 构建
			NoteBean noteBean = new NoteBean();
			noteBean.setId(UUIDUtils.getUUID());
			
			noteBean.setName(String.valueOf(params.get("name")));
			noteBean.setContent(String.valueOf(params.get("content")));
			noteBean.setOwner(String.valueOf(params.get("owner")));
			

			// 执行新增
			DemoDao demoDao = new DemoDao();
			demoDao.addNote(noteBean);
			result = "新增便签成功";
		} catch (Exception e) {
			e.printStackTrace();
			result = "服务器发生错误";
		}
		response.getWriter().write(result);
	}

	/**
	 * 根据 id 获取便签
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result = "";
		try {
			// 获取参数
			Map<String, Object> params = WrapParamUtils.paramToMap(request);

			// 参数校验
			if (ValueUtils.valEmpty(params.get("id"))) {
				result = "id 不能为空";
				response.getWriter().write(result);
				return;
			}

			// 执行查询
			DemoDao demoDao = new DemoDao();
			NoteBean noteBean = demoDao.getNoteById(String.valueOf(params.get("id")));
			if (ValueUtils.valNotEmpty(noteBean)) {
				result = noteBean.toString();
			} else {
				result = "没有该便签";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "服务器发生错误";
		}
		response.getWriter().write(result);
	}

}
