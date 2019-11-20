package com.starry.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.starry.bean.UserBean;
import com.starry.dao.user.GetUserInfoDao;
import com.starry.utils.CustomConstant;
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
 * @date 2019年10月27日下午4:27:56
 * 
 * @Description TODO 获取个人信息接口 Servlet
 */
@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetUserInfoServlet() {
		super();

	}

	// 接口入口
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			// 执行逻辑
			GetUserInfoDao dao = new GetUserInfoDao();
			HttpSession session = request.getSession(false);
			if (ValueUtils.valEmpty(session)) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "请先登陆", null);
			} else {
				String username = String.valueOf(session.getAttribute(CustomConstant.Custom.SESSION_LOGIN_MARK));
				if (ValueUtils.valEmpty(username)) {
					result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "请先登陆", null);
				} else {
					UserBean user = dao.getUserByUsername(username);
					result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "获取成功", user);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "服务器发生错误", null);
		}
		response.getWriter().write(result);
	}

	// 非接口入口
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "访问错误", null));
	}

}
