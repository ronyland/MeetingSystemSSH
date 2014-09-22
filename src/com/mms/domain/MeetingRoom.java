/**
 * 
 */
package com.mms.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Type;

/**
 * @author H
 * 
 */
@Entity
@Table(name = "meeting_room")
//select mr from MeetingRoom mr where mr not in (select mr2 from Meeting m inner join m.meetingRoom mr2 where m.date = '2014-07-08' and m.time = 0)
public class MeetingRoom extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7777453440288724661L;

	static final Logger logger = LogManager.getLogger(MeetingRoom.class.getName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Type(type = "string")
	@Column(name = "address", nullable = false, length = 255)
	private String address;

	@Type(type = "integer")
	@Column(name = "max_count", nullable = false, length = 10)
	private int maxCount;

	@OneToMany(mappedBy = "meetingRoom", fetch = FetchType.LAZY)
	private List<Meeting> meetings;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

}
