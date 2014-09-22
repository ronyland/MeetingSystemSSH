package com.mms.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.mms.enumeration.State;
import com.mms.enumeration.Time;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		session.setAttribute("Allow", State.Allow);
		session.setAttribute("Disallow", State.Disallow);
		session.setAttribute("Submit", State.Submit);
		session.setAttribute("Morning", Time.Morning);
		session.setAttribute("Noon", Time.Noon);
		session.setAttribute("Afternoon", Time.Afternoon);
		session.setAttribute("Dusk", Time.Dusk);
		session.setAttribute("Night", Time.Night);
		session.setAttribute("path", hse.getSession().getServletContext().getContextPath());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
	}

}
