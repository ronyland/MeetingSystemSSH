/**
 * 
 */
package com.mms.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.domain.MeetingRoom;
import com.mms.enumeration.Time;
import com.mms.persistence.MeetingRoomDao;
import com.mms.service.IMeetingRoomService;

/**
 * @author H
 * 
 */
public class MeetingRoomService extends Service implements IMeetingRoomService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8438265770246260150L;

	@Autowired
	private MeetingRoomDao meetingRoomDao;

	public void setMeetingRoomDao(MeetingRoomDao meetingRoomDao) {
		this.meetingRoomDao = meetingRoomDao;
	}

	@Override
	public List<MeetingRoom> listLeisureMeetingRoom(Date date, Time time) {
		return meetingRoomDao.listLeisureMeetingRoom(date, time);
	}
}
