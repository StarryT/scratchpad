package com.starry.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午5:32:38
 * 
 * @Description TODO 参数封装处理
 */
public class WrapParamUtils {

	private WrapParamUtils() {

	}

	/**
	 * request 参数写入 Map
	 * @param request
	 * @return Map<String,Object>
	 * @throws IOException
	 */
	public static Map<String,Object> paramToMap(HttpServletRequest request) throws IOException{
		Map<String,Object> paramMap= new HashMap<String,Object>();
		ServletInputStream is = request.getInputStream();
		String paramString = ValueUtils.convertStreamToString(is);
		
		if(ValueUtils.valNotEmpty(paramString)) {
			paramMap = JSON.parseObject(paramString);
		}else {
			Enumeration<String> enu = request.getParameterNames();
			while(enu.hasMoreElements()){
				String tempEnu = enu.nextElement();
				paramMap.put(tempEnu, request.getParameter(tempEnu));
			}
		}
		return paramMap;
	}

}
