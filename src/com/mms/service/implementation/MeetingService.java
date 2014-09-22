/**
 * 
 */
package com.mms.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.domain.Domain;
import com.mms.domain.Employee;
import com.mms.domain.Meeting;
import com.mms.domain.association.MeetingDeviceRent;
import com.mms.domain.association.MeetingInvitation;
import com.mms.persistence.MeetingDao;
import com.mms.service.IMeetingService;

/**
 * @author H
 * 
 */
public class MeetingService extends Service implements IMeetingService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -643267592963580216L;

	@Autowired
	private MeetingDao meetingDao;

	public void setMeetingDao(MeetingDao meetingDao) {
		this.meetingDao = meetingDao;
	}

	@Override
	public void allowMeeting(Meeting meeting) {
		meetingDao.allowMeeting(meeting);
	}

	@Override
	public void disallowMeeting(Meeting meeting) {
		meetingDao.disallowMeeting(meeting);
	}

	@Override
	public List<Meeting> noteMeeting(Employee employee) {
		return meetingDao.noteMeeting(employee);
	}

	@Override
	public int noteMeetingCount(Employee employee) {
		return meetingDao.noteMeetingCount(employee);
	}

	@Override
	public List<Meeting> noteVerifyMeeting() {
		return meetingDao.noteVerifyMeeting();
	}

	@Override
	public int noteVerifyMeetingCount() {
		return meetingDao.noteVerifyMeetingCount();
	}

	@Override
	public List<Meeting> myMeeting(Employee employee) {
		return meetingDao.myMeeting(employee);
	}

	@Override
	public void saveMeetingTranscation(Meeting meeting, List<MeetingInvitation> meetingInvitations, List<MeetingDeviceRent> meetingDeviceRents) {
		meetingDao.saveTransaction(meeting, meetingInvitations, meetingDeviceRents);
	}

	@Override
	public void updateMeetingTranscation(Meeting meeting, List<MeetingInvitation> meetingInvitations, List<MeetingDeviceRent> meetingDeviceRents) {
		meetingDao.updateTransaction(meeting, meetingInvitations, meetingDeviceRents);
	}

	@Override
	public void deleteMeetingTranscation(Meeting meeting) {
		meetingDao.deleteTransaction(meeting);
	}

	@Override
	public <D extends Domain> int save(D d) {
		throw new RuntimeException();
	}

	@Override
	public <D extends Domain> void update(D d) {
		throw new RuntimeException();
	}

	@Override
	public <D extends Domain> void delete(D d) {
		throw new RuntimeException();
	}

}
