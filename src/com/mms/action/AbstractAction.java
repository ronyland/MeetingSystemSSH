package com.mms.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.mms.util.Pager;
import com.mms.util.Validater;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware, Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3165204448065558182L;

	public static final String ADMIN = "admin";
	public static final String USER = "user";
	public static final String LOGOUT = "logout";
	public static final String LOGIN = "login";

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext servletContext;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public Pager pageChanged() {
		Pager pager = new Pager();

		if (Validater.isInteger(request.getParameter("no"))) {
			pager.setNo(Integer.valueOf(request.getParameter("no")));
		} else {
			pager.setNo(Pager.DEFAULT_NO);
		}

		if (Validater.isInteger(request.getParameter("size"))) {
			pager.setSize(Integer.valueOf(request.getParameter("size")));
		} else {
			pager.setSize(Pager.DEFAULT_SIZE);
		}

		return pager;
	}
}
