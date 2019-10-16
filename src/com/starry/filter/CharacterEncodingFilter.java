package com.starry.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.starry.utils.CustomConstant;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 版权所有 © 2017
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2017年10月16日 下午7:45:42
 * 
 * @Description TODO 处理全站编码过滤器
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/*" })
public class CharacterEncodingFilter implements Filter {

	public CharacterEncodingFilter() {

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 转化ServletRequest为HttpRequest
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding(CustomConstant.Custom.UTF8);
		resp.setCharacterEncoding(CustomConstant.Custom.UTF8);
		resp.setContentType(CustomConstant.ResponseHeader.APPLICATION_JSON);
		chain.doFilter(new MyRequest(req), resp);
	}

	/**
	 * 包装设计模式对request进行处理
	 */
	// request存在一个默认包装类（简化包装模式）
	class MyRequest extends HttpServletRequestWrapper {
		private HttpServletRequest request;

		public MyRequest(HttpServletRequest request) {
			// 用super传入一个被增强对象
			super(request);
			this.request = request;
		}

		// 覆盖实现方法
		@Override
		public String getParameter(String name) {
			String value = this.request.getParameter(name);
			if (!request.getMethod().equalsIgnoreCase("get")) {
				return value;
			}
			if (value == null) {
				return null;
			}
			try {
				return value = new String(value.getBytes(CustomConstant.Custom.UTF8), request.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
