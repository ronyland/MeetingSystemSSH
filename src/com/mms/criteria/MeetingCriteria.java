/**
 * 
 */
package com.mms.criteria;

import java.util.Date;

import com.mms.enumeration.State;
import com.mms.enumeration.Time;

/**
 * @author H
 * 
 */
public class MeetingCriteria extends Criteria {

	private Integer employeeId;
	private Date startDate;
	private Date endDate;
	private String info;
	private State state;
	private Time startTime;
	private Time endTime;
	private String topic;
	private String hostEmployeeName;
	private Integer hostEmployeeId;
	private String address;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getHostEmployeeName() {
		return hostEmployeeName;
	}

	public void setHostEmployeeName(String hostEmployeeName) {
		this.hostEmployeeName = hostEmployeeName;
	}

	public Integer getHostEmployeeId() {
		return hostEmployeeId;
	}

	public void setHostEmployeeId(Integer hostEmployeeId) {
		this.hostEmployeeId = hostEmployeeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
