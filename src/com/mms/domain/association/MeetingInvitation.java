/**
 * 
 */
package com.mms.domain.association;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mms.domain.Employee;
import com.mms.domain.Meeting;

/**
 * @author H
 * 
 */
@Entity
@Table(name = "meeting_invitation")
public class MeetingInvitation extends Association {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8669102828823070410L;

	static final Logger logger = LogManager.getLogger(MeetingInvitation.class.getName());

	@Id
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "meeting_id")
	private Meeting meeting;

	@Id
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
