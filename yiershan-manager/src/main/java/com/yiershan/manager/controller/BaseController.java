package com.yiershan.manager.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * controller基类 所有controller需继承该类<br/>
 * 
 * @author chenhaibing
 *
 */
@Component
public class BaseController {

	protected Logger logger = Logger.getLogger(super.getClass());

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;

	@ModelAttribute
	public void setHttp(HttpServletResponse response, HttpServletRequest request) {

		this.request = request;
		this.response = response;
		this.session = request.getSession();

	}

	/**
	 * 设定返回文件的属性
	 */
	protected void setContentType(String contentType) {
		response.setHeader("Cache-Control", "No-cache");
		response.setHeader("Pragma", "No-cache");
		response.setContentType(contentType);
		response.setDateHeader("Expires", 0);
	}

	
}
