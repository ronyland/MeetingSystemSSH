package com.mms.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionListener implements ServletRequestListener {

	static final Logger logger = LogManager.getLogger(ConnectionListener.class.getName());

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = ((HttpServletRequest) sre.getServletRequest());
		request.getSession().setAttribute("current", request.getServletPath());
		logger.debug(request.getServletPath());
	}

}
