package com.starry.servlet.note;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.bean.NoteBean;
import com.starry.dao.note.DeleteNoteDao;
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
 * @date 2019年10月30日 下午7:33:44
 * 
 * @Description TODO 删除标签
 *
 */
@WebServlet("/DeleteNote")
public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 接口入口
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			Map<String, Object> param = WrapParamUtils.paramToMap(request);
			DeleteNoteDao dnd = new DeleteNoteDao();

			GetNoteByIdDao gnbi=new GetNoteByIdDao();
			NoteBean notebean=gnbi.getNoteById(String.valueOf(param.get("id")));
			
			if (ValueUtils.valNotEmpty(notebean)) {
				dnd.delNote(String.valueOf(param.get("id")));
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "删除成功", null);
				response.getWriter().write(result);
			}else {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "便签不存在", null);
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