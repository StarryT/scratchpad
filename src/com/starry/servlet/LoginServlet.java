package com.starry.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.bean.UserBean;
import com.starry.dao.LoginDao;
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
 * @date 2019年10月27日下午3:38:56
 * 
 * @Description TODO 登录接口 Servlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	// 非接口入口
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "访问错误", null));
	}

	// 接口入口
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			// 获取参数
			Map<String, Object> params = WrapParamUtils.paramToMap(request);

			// 参数校验
			if (ValueUtils.valEmpty(params.get("username"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "username 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(params.get("password"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "password 不能为空", null);
				response.getWriter().write(result);
				return;
			}

			// 执行逻辑
			LoginDao dao = new LoginDao();
			UserBean user = dao.getUser(String.valueOf(params.get("username")), String.valueOf(params.get("password")));
			if (ValueUtils.valEmpty(user)) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "帐号或密码错误", null);
			} else {
				request.getSession().setAttribute(CustomConstant.Custom.SESSION_LOGIN_MARK, user.getUsername());
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "登录成功", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "服务器发生错误", null);
		}
		response.getWriter().write(result);
	}

}
