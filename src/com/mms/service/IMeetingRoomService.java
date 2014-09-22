/**
 * 
 */
package com.mms.service;

import java.util.Date;
import java.util.List;

import com.mms.domain.MeetingRoom;
import com.mms.enumeration.Time;

/**
 * @author H
 * 
 */
public interface IMeetingRoomService extends IService {

	/**
	 * 获取某个时间段的空闲的会议室
	 * 
	 * @return 某个时间段的空闲的会议室
	 */
	public List<MeetingRoom> listLeisureMeetingRoom(Date date, Time time);
}
