/**
 * 
 */
package com.mms.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Type;

import com.mms.enumeration.State;
import com.mms.enumeration.Time;

/**
 * @author H
 * 
 */
@Entity
@Table(name = "meeting")
@NamedQueries(value = {
		@NamedQuery(name = "verifyMeeting", query = "update Meeting m set m.state = :state where m.id = :id"),
		@NamedQuery(name = "noteMeeting", query = "select m from Meeting m inner join m.employees e inner join m.meetingRoom where e.id = :id and m.state = :state"),
		@NamedQuery(name = "noteMeetingCount", query = "select count(m) from Meeting m inner join m.employees e inner join m.meetingRoom where e.id = :id and m.state = :state"),
		@NamedQuery(name = "noteVerifyMeeting", query = "from Meeting m where m.state = :state"),
		@NamedQuery(name = "noteVerifyMeetingCount", query = "select count(m) from Meeting m where m.state = :state"),
		@NamedQuery(name = "myMeeting", query = "from Meeting m where m.hostEmployee.id = :id") })
public class Meeting extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6686866375418309724L;

	static final Logger logger = LogManager.getLogger(Meeting.class.getName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Type(type = "string")
	@Column(name = "topic", nullable = false, length = 255)
	private String topic;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "meeting_id")
	private MeetingRoom meetingRoom;

	@Type(type = "date")
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date date;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "time", nullable = false, length = 1)
	private Time time;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "host_employee_id")
	private Employee hostEmployee;

	@Type(type = "integer")
	@Column(name = "count", nullable = false, length = 10)
	private int count;

	@Type(type = "string")
	@Column(name = "info", nullable = false, length = 255)
	private String info;

	@Type(type = "string")
	@Column(name = "record", nullable = true, length = 255)
	private String record;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "state", nullable = false, length = 1)
	private State state;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "meeting_invitation", joinColumns = @JoinColumn(name = "meeting_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employee> employees;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "meeting_device_rent", joinColumns = @JoinColumn(name = "meeting_id"), inverseJoinColumns = @JoinColumn(name = "device_id"))
	private List<Device> devices;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Employee getHostEmployee() {
		return hostEmployee;
	}

	public void setHostEmployee(Employee hostEmployee) {
		this.hostEmployee = hostEmployee;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

}
