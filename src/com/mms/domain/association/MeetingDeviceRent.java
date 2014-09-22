/**
 * 
 */
package com.mms.domain.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Type;

import com.mms.domain.Device;
import com.mms.domain.Meeting;

/**
 * @author H
 * 
 */
@Entity
@Table(name = "meeting_device_rent")
public class MeetingDeviceRent extends Association {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3930393413579049261L;

	static final Logger logger = LogManager.getLogger(MeetingDeviceRent.class.getName());

	@Id
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "meeting_id")
	private Meeting meeting;

	@Id
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "device_id")
	private Device device;

	@Type(type = "integer")
	@Column(name = "count", nullable = false, length = 10)
	private int count;

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
