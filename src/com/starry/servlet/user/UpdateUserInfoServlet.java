package com.starry.servlet.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.starry.bean.UserBean;
import com.starry.dao.user.GetUserInfoDao;
import com.starry.dao.user.UpdateUserInfoDao;
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
 * @date 2019年10月30日 下午4:23:43
 * 
 * @Description TODO
 *
 */
@WebServlet("/UpdateUserInfo")
public class UpdateUserInfoServlet extends HttpServlet {
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
		boolean update=true;
		try {
			// 获取参数
			Map<String, Object> param = WrapParamUtils.paramToMap(request);
			HttpSession session = request.getSession(false);
			
			GetUserInfoDao guid=new GetUserInfoDao();
			UserBean userbean=guid.getUserByUsername(String.valueOf(session.getAttribute(CustomConstant.Custom.SESSION_LOGIN_MARK)));
			
			//校验
			if((param.get("nickname")).equals(userbean.getNickname())) {
				update=false;
			}
			if((param.get("gender")).equals(userbean.getGender())) {
				update=false;
			}
			if((param.get("phone")).equals(userbean.getPhone())) {
				update=false;
			}
			if((param.get("email")).equals(userbean.getEmail())) {
				update=false;
			}
			if(!update) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "您未修改", null);
				return;
			}
			
			UpdateUserInfoDao tuid=new UpdateUserInfoDao();
			userbean.setNickname(String.valueOf(param.get("nickname")));
			userbean.setGender(String.valueOf(param.get("gender")));
			userbean.setPhone(String.valueOf(param.get("phone")));
			userbean.setEmail(String.valueOf(param.get("email")));

			tuid.getUserInfo(userbean);
			result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "修改成功", null);
			response.getWriter().write(result);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "服务器出行异常", null);
			response.getWriter().write(result);
		}
	}

}