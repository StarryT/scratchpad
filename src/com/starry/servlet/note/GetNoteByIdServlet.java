package com.starry.servlet.note;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.bean.NoteBean;
import com.starry.dao.note.GetNoteByIdDao;
import com.starry.utils.CustomConstant;
import com.starry.utils.ValueUtils;
import com.starry.utils.WrapParamUtils;

/**
 * 
 * @copyright ：还没想好
 * 
 * @author starry
 * 
 * @version 1.0
 * 
 * @date 2019年10月30日 下午8:26:41
 * 
 * @Description TODO
 *
 */
@WebServlet("/GetNoteById")
public class GetNoteByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 接口入口
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			Map<String, Object> param = WrapParamUtils.paramToMap(request);

			GetNoteByIdDao gnbi = new GetNoteByIdDao();
			NoteBean notebean = gnbi.getNoteById(String.valueOf(param.get("id")));

			if (ValueUtils.valNotEmpty(notebean)) {
				response.getWriter().println(notebean);
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "获取成功", null);
				response.getWriter().write(result);
			} else {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "未找到便签", null);
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