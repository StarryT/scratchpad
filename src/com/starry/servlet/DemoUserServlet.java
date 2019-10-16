package com.starry.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starry.bean.UserBean;
import com.starry.dao.DemoDao;
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
 * @Description TODO 用于演示流程的 Servlet，发布时删除
 */
@WebServlet("/demoUser")
public class DemoUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DemoUserServlet() {
		super();
	}

	/**
	 * 新增用户
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			// 获取参数
			Map<String, Object> params = WrapParamUtils.paramToMap(request);

			// 参数校验
			if (ValueUtils.valEmpty(params.get("username"))) {
				result = "username 不能为空";
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(params.get("password"))) {
				result = "password 不能为空";
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(params.get("nickname"))) {
				result = "nickname 不能为空";
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(params.get("gender"))) {
				result = "gender 不能为空";
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(params.get("phone"))) {
				result = "phone 不能为空";
				response.getWriter().write(result);
				return;
			}
			if (ValueUtils.valEmpty(params.get("email"))) {
				result = "email 不能为空";
				response.getWriter().write(result);
				return;
			}

			// UserBean 构建
			UserBean userBean = new UserBean();
			userBean.setUsername(String.valueOf(params.get("username")));
			userBean.setPassword(String.valueOf(params.get("password")));
			userBean.setNickname(String.valueOf(params.get("nickname")));
			userBean.setGender(String.valueOf(params.get("gender")));
			userBean.setEmail(String.valueOf(params.get("phone")));
			userBean.setPhone(String.valueOf(params.get("email")));

			// 执行新增
			DemoDao demoDao = new DemoDao();
			demoDao.addUser(userBean);
			result = "新增用户成功";
		} catch (Exception e) {
			e.printStackTrace();
			result = "服务器发生错误";
		}
		response.getWriter().write(result);
	}

	/**
	 * 根据 username 获取用户
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result = "";
		try {
			// 获取参数
			Map<String, Object> params = WrapParamUtils.paramToMap(request);

			// 参数校验
			if (ValueUtils.valEmpty(params.get("username"))) {
				result = "username 不能为空";
				response.getWriter().write(result);
				return;
			}

			// 执行查询
			DemoDao demoDao = new DemoDao();
			UserBean userBean = demoDao.getUserByUsername(String.valueOf(params.get("username")));
			if (ValueUtils.valNotEmpty(userBean)) {
				result = userBean.toString();
			} else {
				result = "没有该用户";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "服务器发生错误";
		}
		response.getWriter().write(result);
	}

}
