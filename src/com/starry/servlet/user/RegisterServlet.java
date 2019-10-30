package com.starry.servlet.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.bean.UserBean;
import com.starry.dao.user.GetUserInfoDao;
import com.starry.dao.user.RegisterDao;
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
 * @date 2019年10月30日 上午10:42:14
 * 
 * @Description TODO 用户注册
 *
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
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
		try {
			// 获取参数
			Map<String, Object> param = WrapParamUtils.paramToMap(request);

			// 参数校验
			if (ValueUtils.valEmpty(param.get("username"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "username 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(param.get("password"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "password 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(param.get("gender"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "gender 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(param.get("nickname"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "nickname 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(param.get("phone"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "phone 不能为空", null);
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(param.get("email"))) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "email 不能为空", null);
				response.getWriter().write(result);
				return;
			}

			// 执行逻辑
			RegisterDao register = new RegisterDao();
			UserBean userbean = new UserBean();
			userbean.setUsername(String.valueOf(param.get("username")));
			userbean.setPassword(String.valueOf(param.get("password")));
			userbean.setNickname(String.valueOf(param.get("nickname")));
			userbean.setGender(String.valueOf(param.get("gender")));
			userbean.setPhone(String.valueOf(param.get("phone")));
			userbean.setEmail(String.valueOf(param.get("email")));

			GetUserInfoDao rd = new GetUserInfoDao();
			UserBean ub = rd.getUserByUsername((String.valueOf(param.get("username"))));
			if (ub != null) {
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "注册的用户已存在", null);
				response.getWriter().write(result);
				return;
			} else {
				System.out.println(userbean);
				register.register(userbean);
				result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_SUCCESS, "注册成功", null);
				response.getWriter().write(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = WrapParamUtils.jsonResponse(CustomConstant.Custom.CODE_FAILURE, "服务器出行异常", null);
		}

	}

}