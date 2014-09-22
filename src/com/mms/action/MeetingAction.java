package com.mms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.domain.Meeting;
import com.mms.service.IMeetingService;
import com.mms.util.Pager;
import com.mms.util.Validater;

public class MeetingAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4513121705600749697L;

	@Autowired
	public IMeetingService meetingService;

	public void setMeetingService(IMeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public String allowMeeting() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			Meeting meeting = new Meeting();
			meeting.setId(id);
			meetingService.allowMeeting(meeting);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String disallowMeeting() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			Meeting meeting = new Meeting();
			meeting.setId(id);
			meetingService.disallowMeeting(meeting);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String noteVerifyMeeting() {
		try {
			Pager pager = pageChanged();

			List<Meeting> meetings = meetingService.noteVerifyMeeting();

			request.setAttribute("meetings", meetings);
			request.setAttribute("totalCount", meetings.size());
			request.setAttribute("pager", pager);
			request.setAttribute("current", request.getServletPath());

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
