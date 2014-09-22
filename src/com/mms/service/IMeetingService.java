/**
 * 
 */
package com.mms.service;

import java.util.List;

import com.mms.domain.Employee;
import com.mms.domain.Meeting;
import com.mms.domain.association.MeetingDeviceRent;
import com.mms.domain.association.MeetingInvitation;

/**
 * @author H
 * 
 */
public interface IMeetingService extends IService {
	/**
	 * 使会议的状态变为审核通过
	 * 
	 * @param meeting
	 *            要审核通过的会议的对象
	 */
	public void allowMeeting(Meeting meeting);

	/**
	 * 使会议的状态变为审核失败
	 * 
	 * @param meeting
	 *            要审核失败的会议的对象
	 */
	public void disallowMeeting(Meeting meeting);

	/**
	 * 获取员工需要参与的会议
	 * 
	 * @param employee
	 *            员工对象
	 * @return 员工需要参与的会议
	 */
	public List<Meeting> noteMeeting(Employee employee);

	/**
	 * 获取员工需要参与的会议的数量
	 * 
	 * @param employee
	 *            员工对象
	 * @return 员工需要参与的会议的数量
	 */
	public int noteMeetingCount(Employee employee);

	/**
	 * 获取管理员需要审核的会议
	 * 
	 * @return 管理员需要审核的会议
	 */
	public List<Meeting> noteVerifyMeeting();

	/**
	 * 获取管理员需要审核的会议的数量
	 * 
	 * @return 管理员需要审核的会议的数量
	 */
	public int noteVerifyMeetingCount();

	/**
	 * 获取当前员工发起的会议
	 * 
	 * @param employee
	 *            当前员工
	 * @return 当前员工发起的会议
	 */
	public List<Meeting> myMeeting(Employee employee);

	/**
	 * @see 插入会议对象时应该使用此方法，而不是使用普通的save()方法
	 * @param meeting
	 *            会议对象
	 * @param meetingInvitations
	 *            会议邀请对象
	 * @param meetingDeviceRents
	 *            会议设备借用对象
	 */
	public void saveMeetingTranscation(Meeting meeting, List<MeetingInvitation> meetingInvitations, List<MeetingDeviceRent> meetingDeviceRents);

	/**
	 * @see 更新会议对象时应该使用此方法，而不是使用普通的save()方法
	 * @param meeting
	 *            会议对象
	 * @param meetingInvitations
	 *            会议邀请对象
	 * @param meetingDeviceRents
	 *            会议设备借用对象
	 */
	public void updateMeetingTranscation(Meeting meeting, List<MeetingInvitation> meetingInvitations, List<MeetingDeviceRent> meetingDeviceRents);

	/**
	 * @see 删除会议对象时应该使用此方法，而不是使用普通的save()方法
	 * @param meeting
	 *            会议对象
	 */
	public void deleteMeetingTranscation(Meeting meeting);

}
