package com.mms.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.criteria.MeetingRoomCriteria;
import com.mms.domain.MeetingRoom;
import com.mms.enumeration.Time;
import com.mms.service.IMeetingRoomService;
import com.mms.util.Pager;
import com.mms.util.Validater;

public class MeetingRoomAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2447001104259516667L;

	@Autowired
	public IMeetingRoomService meetingRoomService;

	public void setMeetingRoomService(IMeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}

	public String addMeetingRoom() {
		try {
			String address = null;
			if (!Validater.isEmptyOrNull(request.getParameter("address"))) {
				address = request.getParameter("address");
			} else {
				throw new Exception();
			}

			int maxCount = 0;
			if (Validater.isInteger(request.getParameter("maxCount"))) {
				maxCount = Integer.valueOf(request.getParameter("maxCount"));
			} else {
				throw new Exception();
			}

			MeetingRoom meetingRoom = new MeetingRoom();
			meetingRoom.setAddress(address);
			meetingRoom.setMaxCount(maxCount);
			meetingRoomService.save(meetingRoom);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String deleteMeetingRoom() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			MeetingRoom meetingRoom = meetingRoomService.load(id);
			meetingRoomService.delete(meetingRoom);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String searchMeetingRoom() {
		try {
			String address = null;
			if (!Validater.isEmptyOrNull(request.getParameter("address"))) {
				address = request.getParameter("address");
			}

			Integer maxCount = null;
			if (Validater.isInteger(request.getParameter("maxCount"))) {
				maxCount = Integer.valueOf(request.getParameter("maxCount"));
			}

			MeetingRoomCriteria meetingRoomCriteria = new MeetingRoomCriteria();
			meetingRoomCriteria.setAddress(address);
			meetingRoomCriteria.setMaxCount(maxCount);

			Pager pager = pageChanged();

			List<MeetingRoom> meetingRooms = meetingRoomService.search(meetingRoomCriteria, pager);

			request.setAttribute("address", address);
			request.setAttribute("maxCount", maxCount);

			if (address != null || maxCount != null) {
				request.setAttribute("searching", true);
			} else {
				request.setAttribute("searching", false);
			}

			request.setAttribute("meetingRooms", meetingRooms);
			request.setAttribute("totalCount", meetingRooms.size());
			request.setAttribute("pager", pager);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String updateMeetingRoom() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			String address = null;
			if (!Validater.isEmptyOrNull(request.getParameter("address"))) {
				address = request.getParameter("address");
			} else {
				throw new Exception();
			}

			int maxCount = 0;
			if (Validater.isInteger(request.getParameter("maxCount"))) {
				maxCount = Integer.valueOf(request.getParameter("maxCount"));
			} else {
				throw new Exception();
			}

			MeetingRoom meetingRoom = new MeetingRoom();
			meetingRoom.setId(id);
			meetingRoom.setAddress(address);
			meetingRoom.setMaxCount(maxCount);
			meetingRoomService.update(meetingRoom);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String listLeisureRoom() {
		try {
			Date date = null;
			if (!Validater.isEmptyOrNull(request.getParameter("date"))) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
				simpleDateFormat.applyPattern("yyyy-MM-dd");
				date = simpleDateFormat.parse(request.getParameter("date"));
			} else {
				throw new Exception();
			}

			Time time = null;
			if (!Validater.isEmptyOrNull(request.getParameter("time"))) {
				time = Time.valueOf(request.getParameter("time"));
			} else {
				throw new Exception();
			}

			List<MeetingRoom> meetingRooms = meetingRoomService.listLeisureMeetingRoom(date, time);

			StringBuilder sb = new StringBuilder();
			for (MeetingRoom meetingRoom : meetingRooms) {
				sb.append("<option id='meetingRoom_" + meetingRoom.getId() + "' value='" + meetingRoom.getId() + "'>" + meetingRoom.getAddress()
						+ "(" + meetingRoom.getMaxCount() + ")</option>");
			}

			request.setAttribute("data", sb.toString());

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
