package com.starry.servlet.note;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.bean.NoteBean;
import com.starry.dao.note.GetAllNoteDao;
import com.starry.utils.CustomConstant;
import com.starry.utils.WrapParamUtils;

/**
 * 
 * @copyright ：还没想好
 * 
 * @author starry
 * 
 * @version 1.0
 * 
 * @date 2019年10月30日 下午8:05:42
 * 
 * @Description TODO 获得所有便签
 *
 */
@WebServlet("/GetAllNote")
public class GetAllNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 接口入口
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			// 获取参数
			Map<String, Object> param = WrapParamUtils.paramToMap(request);
			GetAllNoteDao gand = new GetAllNoteDao();
			List<NoteBean> list = gand.getAllNote(String.valueOf(param.get("owner")));
			if (list.isEmpty()) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "获取失败，请先登陆", null);
				response.getWriter().write(result);
			}else {
				for (NoteBean nb : list) {
					response.getWriter().println(nb);
				}
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "获取成功", null);
				response.getWriter().write(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "服务器出行异常", null);
			response.getWriter().write(result);
		}

	}

	// 非接口入口
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "访问错误", null));
	}

}