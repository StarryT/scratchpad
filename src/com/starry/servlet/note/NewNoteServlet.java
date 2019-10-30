package com.starry.servlet.note;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.bean.NoteBean;
import com.starry.dao.note.NewNoteDao;
import com.starry.utils.CustomConstant;
import com.starry.utils.UUIDUtils;
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
 * @date 2019年10月30日 下午4:30:11
 * 
 * @Description TODO 新建便签
 *
 */
@WebServlet("/NewNote")
public class NewNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//非接口入口
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "访问错误", null));
	}
	
	//接口入口
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			// 获取参数
			Map<String, Object> param = WrapParamUtils.paramToMap(request);

			// 参数校验
			if (ValueUtils.valEmpty(param.get("name"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "name 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(param.get("owner"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "owner 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(param.get("content"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "content 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			

			// 执行逻辑
			NewNoteDao newnote = new NewNoteDao();
			NoteBean notebean = new NoteBean();
			notebean.setId(UUIDUtils.getUUID());
			notebean.setName((String.valueOf(param.get("name"))));
			notebean.setOwner((String.valueOf(param.get("owner"))));
			notebean.setContent((String.valueOf(param.get("content"))));
			
//			GetNoteByIdDao gnid=new GetNoteByIdDao();
//			NoteBean nb = gnid.getNoteById(notebean.getId());
//			if (nb != null) {
//				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "新建的便签已存在", null);
//				response.getWriter().write(result);
//				return;
//			} else {
				newnote.newNote(notebean);
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "新建成功", null);
				response.getWriter().write(result);
//			}
		} catch (Exception e) {
			e.printStackTrace();
			result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "服务器出行异常", null);
			response.getWriter().write(result);
		}
	}

}