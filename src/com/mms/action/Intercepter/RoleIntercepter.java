/**
 * 
 */
package com.mms.action.Intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author H
 * 
 */
public class RoleIntercepter implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9090796248559383466L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		return invocation.invoke();
	}

}
