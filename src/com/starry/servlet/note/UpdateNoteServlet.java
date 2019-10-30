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
import com.starry.dao.note.UpdateNoteDao;
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
 * @date 2019年10月30日 下午7:37:36
 * 
 * @Description TODO 更新便签
 *
 */
@WebServlet("/UpdateNote")
public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 非接口入口
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "访问错误", null));
	}

	// 接口入口
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		boolean update = true;
		try {
			Map<String, Object> param = WrapParamUtils.paramToMap(request);

			GetNoteByIdDao gnbi = new GetNoteByIdDao();
			NoteBean notebean = gnbi.getNoteById(String.valueOf(param.get("id")));

			if (ValueUtils.valEmpty(notebean)) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "未找到便签", null);
				response.getWriter().write(result);
				return;
			}
				// 校验
				if ((String.valueOf(param.get("name"))).equals(notebean.getName())) {
					update = false;
				}
				if ((String.valueOf(param.get("content"))).equals(notebean.getContent())) {
					update = false;
				}

				if (!update) {
					result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "您未做出修改", null);
					return;
				}

				// 逻辑代码
				UpdateNoteDao und = new UpdateNoteDao();
				und.updateNote(notebean);
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "修改成功", null);
				response.getWriter().write(result);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "服务器出行异常", null);
			response.getWriter().write(result);
		}
	}

}