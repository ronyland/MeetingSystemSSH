package com.mms.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.criteria.MeetingCriteria;
import com.mms.domain.Department;
import com.mms.domain.Device;
import com.mms.domain.Employee;
import com.mms.domain.Meeting;
import com.mms.domain.MeetingRoom;
import com.mms.domain.association.MeetingDeviceRent;
import com.mms.domain.association.MeetingInvitation;
import com.mms.enumeration.State;
import com.mms.enumeration.Time;
import com.mms.service.IDepartmentService;
import com.mms.service.IDeviceService;
import com.mms.service.IEmployeeService;
import com.mms.service.IMeetingRoomService;
import com.mms.service.IMeetingService;
import com.mms.util.Pager;
import com.mms.util.Validater;

public class CenterAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1268486809137488908L;

	@Autowired
	public IMeetingService meetingService;

	@Autowired
	public IEmployeeService employeeService;

	@Autowired
	public IDepartmentService departmentService;

	@Autowired
	public IMeetingRoomService meetingRoomService;

	@Autowired
	public IDeviceService deviceService;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMeetingService(IMeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setMeetingRoomService(IMeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}

	public void setDeviceService(IDeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public String invitedMeeting() {
		try {
			String topic = null;
			if (!Validater.isEmptyOrNull(request.getParameter("topic"))) {
				topic = request.getParameter("topic");
			}

			String hostEmployeeName = null;
			if (!Validater.isEmptyOrNull(request.getParameter("hostEmployeeName"))) {
				hostEmployeeName = request.getParameter("hostEmployeeName");
			}

			String address = null;
			if (!Validater.isEmptyOrNull(request.getParameter("address"))) {
				address = request.getParameter("address");
			}

			Date startDate = null;
			try {
				String startDateString = request.getParameter("startDate");
				startDate = new SimpleDateFormat().parse(startDateString);
			} catch (Exception e) {
			}

			Date endDate = null;
			try {
				String endDateString = request.getParameter("endDate");
				endDate = new SimpleDateFormat().parse(endDateString);
			} catch (Exception e) {
			}

			State state = null;
			try {
				state = State.enumOf(Integer.valueOf(request.getParameter("state")));
			} catch (Exception e) {
			}

			Time startTime = null;
			try {
				String startTimeString = request.getParameter("startTime");
				startTime = Time.enumOf(Integer.valueOf(startTimeString));
			} catch (Exception e) {
			}

			Time endTime = null;
			try {
				String endTimeString = request.getParameter("endTime");
				endTime = Time.enumOf(Integer.valueOf(endTimeString));
			} catch (Exception e) {
			}

			Employee employee = (Employee) request.getSession().getAttribute("user");

			MeetingCriteria meetingCriteria = new MeetingCriteria();
			meetingCriteria.setEmployeeId(employee.getId());
			meetingCriteria.setAddress(address);
			meetingCriteria.setStartDate(startDate);
			meetingCriteria.setEndDate(endDate);
			meetingCriteria.setStartTime(startTime);
			meetingCriteria.setEndTime(endTime);
			meetingCriteria.setHostEmployeeName(hostEmployeeName);
			meetingCriteria.setTopic(topic);
			meetingCriteria.setState(state);

			Pager pager = pageChanged();

			List<Meeting> meetings = meetingService.search(meetingCriteria, pager);

			request.setAttribute("topic", topic);
			request.setAttribute("address", address);
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("startTime", startTime);
			request.setAttribute("endTime", endTime);

			if (topic != null || address != null || startDate != null || endDate != null || startTime != null || endTime != null) {
				request.setAttribute("searching", true);
			} else {
				request.setAttribute("searching", false);
			}

			request.setAttribute("meetings", meetings);
			request.setAttribute("totalCount", meetings.size());
			request.setAttribute("pager", pager);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String myMeeting() {
		try {
			String topic = null;
			if (!Validater.isEmptyOrNull(request.getParameter("topic"))) {
				topic = request.getParameter("topic");
			}

			String hostEmployeeName = null;
			if (!Validater.isEmptyOrNull(request.getParameter("hostEmployeeName"))) {
				hostEmployeeName = request.getParameter("hostEmployeeName");
			}

			String address = null;
			if (!Validater.isEmptyOrNull(request.getParameter("address"))) {
				address = request.getParameter("address");
			}

			Date startDate = null;
			try {
				String startDateString = request.getParameter("startDate");
				startDate = new SimpleDateFormat().parse(startDateString);
			} catch (Exception e) {
			}

			Date endDate = null;
			try {
				String endDateString = request.getParameter("endDate");
				endDate = new SimpleDateFormat().parse(endDateString);
			} catch (Exception e) {
			}

			State state = null;
			try {
				state = State.enumOf(Integer.valueOf(request.getParameter("state")));
			} catch (Exception e) {
			}

			Time startTime = null;
			try {
				String startTimeString = request.getParameter("startTime");
				startTime = Time.enumOf(Integer.valueOf(startTimeString));
			} catch (Exception e) {
			}

			Time endTime = null;
			try {
				String endTimeString = request.getParameter("endTime");
				endTime = Time.enumOf(Integer.valueOf(endTimeString));
			} catch (Exception e) {
			}

			Employee employee = (Employee) request.getSession().getAttribute("user");

			MeetingCriteria meetingCriteria = new MeetingCriteria();
			meetingCriteria.setAddress(address);
			meetingCriteria.setStartDate(startDate);
			meetingCriteria.setEndDate(endDate);
			meetingCriteria.setStartTime(startTime);
			meetingCriteria.setEndTime(endTime);
			meetingCriteria.setHostEmployeeName(hostEmployeeName);
			meetingCriteria.setHostEmployeeId(employee.getId());
			meetingCriteria.setTopic(topic);
			meetingCriteria.setState(state);

			Pager pager = pageChanged();

			List<Meeting> meetings = meetingService.search(meetingCriteria, pager);

			request.setAttribute("topic", topic);
			request.setAttribute("address", address);
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("startTime", startTime);
			request.setAttribute("endTime", endTime);

			if (topic != null || address != null || startDate != null || endDate != null || startTime != null || endTime != null) {
				request.setAttribute("searching", true);
			} else {
				request.setAttribute("searching", false);
			}

			request.setAttribute("meetings", meetings);
			request.setAttribute("totalCount", meetings.size());
			request.setAttribute("pager", pager);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String noteMeeting() {
		try {
			Pager pager = pageChanged();

			Employee employee = (Employee) request.getSession().getAttribute("user");

			MeetingCriteria meetingCriteria = new MeetingCriteria();
			meetingCriteria.setEmployeeId(employee.getId());

			List<Meeting> meetings = meetingService.search(meetingCriteria, pager);

			request.setAttribute("meetings", meetings);
			request.setAttribute("totalCount", meetings.size());
			request.setAttribute("pager", pager);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String subscribe() {
		try {
			String topic = null;
			if (!Validater.isEmptyOrNull(request.getParameter("topic"))) {
				topic = request.getParameter("topic");
			} else {
				throw new Exception();
			}

			String info = null;
			if (!Validater.isEmptyOrNull(request.getParameter("info"))) {
				info = request.getParameter("info");
			} else {
				throw new Exception();
			}

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

			int meetingRoomId = 0;
			if (!Validater.isEmptyOrNull(request.getParameter("meetingRoomId"))) {
				meetingRoomId = Integer.valueOf(request.getParameter("meetingRoomId"));
			} else {
				throw new Exception();
			}

			int[] employeeIds = null;
			if (!Validater.isEmptyOrNull(request.getParameter("employeeData"))) {
				String employeeData = request.getParameter("employeeData");
				String[] employeeIdsString = employeeData.split(",");
				employeeIds = new int[employeeIdsString.length];
				for (int i = 0; i < employeeIdsString.length; i++) {
					employeeIds[i] = Integer.valueOf(employeeIdsString[i]);
				}
			} else {
				throw new Exception();
			}

			int[] deviceIds = null;
			int[] rentCounts = null;
			if (!Validater.isEmptyOrNull(request.getParameter("deviceData"))) {
				String deviceData = request.getParameter("deviceData");
				String[] deviceIdsString = deviceData.split(",");
				deviceIds = new int[deviceIdsString.length];
				rentCounts = new int[deviceIdsString.length];
				for (int i = 0; i < deviceIdsString.length; i++) {
					String[] string = deviceIdsString[i].split("\\*");
					deviceIds[i] = Integer.valueOf(string[0]);
					rentCounts[i] = Integer.valueOf(string[1]);
				}
			} else {
				throw new Exception();
			}

			Employee hostEmployee = (Employee) request.getSession().getAttribute("user");

			MeetingRoom meetingRoom = meetingRoomService.load(meetingRoomId);

			Meeting meeting = new Meeting();
			meeting.setTopic(topic);
			meeting.setDate(date);
			meeting.setTime(time);
			meeting.setHostEmployee(hostEmployee);
			meeting.setCount(employeeIds.length);
			meeting.setMeetingRoom(meetingRoom);
			meeting.setInfo(info);
			meeting.setState(State.Submit);

			if (rentCounts.length != deviceIds.length) {
				throw new Exception();
			}

			List<MeetingInvitation> meetingInvitations = new ArrayList<MeetingInvitation>();
			for (int i = 0; i < rentCounts.length; i++) {
				MeetingInvitation meetingInvitation = new MeetingInvitation();
				meetingInvitation.setEmployee((Employee) employeeService.load(employeeIds[i]));
				meetingInvitations.add(meetingInvitation);
			}

			List<MeetingDeviceRent> meetingDeviceRents = new ArrayList<MeetingDeviceRent>();
			for (int i = 0; i < rentCounts.length; i++) {
				MeetingDeviceRent meetingDeviceRent = new MeetingDeviceRent();
				meetingDeviceRent.setDevice((Device) deviceService.load(deviceIds[i]));
				meetingDeviceRent.setCount(rentCounts[i]);
				meetingDeviceRents.add(meetingDeviceRent);
			}

			meetingService.saveMeetingTranscation(meeting, meetingInvitations, meetingDeviceRents);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String subscribePrepare() {
		try {
			List<Department> departments = null;
			List<Device> devices = null;
			departments = departmentService.list();
			devices = deviceService.list();

			request.setAttribute("departments", departments);
			request.setAttribute("devices", devices);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String updateMeeting() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			String topic = null;
			if (!Validater.isEmptyOrNull(request.getParameter("topic"))) {
				topic = request.getParameter("topic");
			} else {
				throw new Exception();
			}

			String info = null;
			if (!Validater.isEmptyOrNull(request.getParameter("info"))) {
				info = request.getParameter("info");
			} else {
				throw new Exception();
			}

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

			int meetingRoomId = 0;
			if (!Validater.isEmptyOrNull(request.getParameter("meetingRoomId"))) {
				meetingRoomId = Integer.valueOf(request.getParameter("meetingRoomId"));
			} else {
				throw new Exception();
			}

			int[] employeeIds = null;
			if (!Validater.isEmptyOrNull(request.getParameter("employeeData"))) {
				String employeeData = request.getParameter("employeeData");
				String[] employeeIdsString = employeeData.split(",");
				employeeIds = new int[employeeIdsString.length];
				for (int i = 0; i < employeeIdsString.length; i++) {
					employeeIds[i] = Integer.valueOf(employeeIdsString[i]);
				}
			} else {
				throw new Exception();
			}

			int[] deviceIds = null;
			int[] rentCounts = null;
			if (!Validater.isEmptyOrNull(request.getParameter("deviceData"))) {
				String deviceData = request.getParameter("deviceData");
				String[] deviceIdsString = deviceData.split(",");
				deviceIds = new int[deviceIdsString.length];
				rentCounts = new int[deviceIdsString.length];
				for (int i = 0; i < deviceIdsString.length; i++) {
					String[] string = deviceIdsString[i].split("\\*");
					deviceIds[i] = Integer.valueOf(string[0]);
					rentCounts[i] = Integer.valueOf(string[1]);
				}
			} else {
				throw new Exception();
			}

			Employee hostEmployee = (Employee) request.getSession().getAttribute("user");

			MeetingRoom meetingRoom = meetingRoomService.load(meetingRoomId);

			Meeting meeting = new Meeting();
			meeting.setId(id);
			meeting.setTopic(topic);
			meeting.setDate(date);
			meeting.setTime(time);
			meeting.setHostEmployee(hostEmployee);
			meeting.setCount(employeeIds.length);
			meeting.setMeetingRoom(meetingRoom);
			meeting.setInfo(info);

			if (rentCounts.length != deviceIds.length) {
				throw new Exception();
			}

			List<MeetingInvitation> meetingInvitations = new ArrayList<MeetingInvitation>();
			for (int i = 0; i < rentCounts.length; i++) {
				MeetingInvitation meetingInvitation = new MeetingInvitation();
				meetingInvitation.setEmployee((Employee) employeeService.load(employeeIds[i]));
				meetingInvitation.setMeeting(meeting);
				meetingInvitations.add(meetingInvitation);
			}

			List<MeetingDeviceRent> meetingDeviceRents = new ArrayList<MeetingDeviceRent>();
			for (int i = 0; i < rentCounts.length; i++) {
				MeetingDeviceRent meetingDeviceRent = new MeetingDeviceRent();
				meetingDeviceRent.setDevice((Device) deviceService.load(deviceIds[i]));
				meetingDeviceRent.setMeeting(meeting);
				meetingDeviceRent.setCount(rentCounts[i]);
				meetingDeviceRents.add(meetingDeviceRent);
			}

			meetingService.updateMeetingTranscation(meeting, meetingInvitations, meetingDeviceRents);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String updateMeetingPrepare() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			Meeting meeting = null;
			List<Department> departments = null;
			List<Device> devices = null;
			List<MeetingInvitation> meetingInvitations = new ArrayList<MeetingInvitation>();
			List<MeetingDeviceRent> meetingDeviceRents = new ArrayList<MeetingDeviceRent>();
			MeetingRoom meetingRoom = null;

			StringBuilder employeeIds = new StringBuilder();
			StringBuilder employeeNames = new StringBuilder();
			StringBuilder deviceIds = new StringBuilder();
			StringBuilder deviceNames = new StringBuilder();
			StringBuilder rentCounts = new StringBuilder();

			meeting = meetingService.load(id);
			departments = departmentService.list();
			devices = deviceService.list();

			for (Employee employee : meeting.getEmployees()) {
				MeetingInvitation meetingInvitation = new MeetingInvitation();
				meetingInvitation.setMeeting(meeting);
				meetingInvitation.setEmployee(employee);
				meetingInvitations.add(meetingInvitation);
			}

			for (Device device : meeting.getDevices()) {
				MeetingDeviceRent meetingDeviceRent = new MeetingDeviceRent();
				meetingDeviceRent.setMeeting(meeting);
				meetingDeviceRent.setDevice(device);
				meetingDeviceRents.add(meetingDeviceRent);
			}

			meetingRoom = meeting.getMeetingRoom();

			for (int i = 0; i < meetingInvitations.size(); i++) {
				employeeIds.append("'" + meetingInvitations.get(i).getEmployee().getId() + "'");
				employeeNames.append("'" + meetingInvitations.get(i).getEmployee().getName() + "'");
				if (i < meetingInvitations.size() - 1) {
					employeeIds.append(",");
					employeeNames.append(",");
				}
			}

			for (int i = 0; i < meetingDeviceRents.size(); i++) {
				deviceIds.append("'" + meetingDeviceRents.get(i).getDevice().getId() + "'");
				deviceNames.append("'" + meetingDeviceRents.get(i).getDevice().getName() + "'");
				rentCounts.append("'" + meetingDeviceRents.get(i).getCount() + "'");
				if (i < meetingDeviceRents.size() - 1) {
					deviceIds.append(",");
					deviceNames.append(",");
					rentCounts.append(",");
				}
			}

			request.setAttribute("meeting", meeting);
			request.setAttribute("departments", departments);
			request.setAttribute("devices", devices);
			request.setAttribute("employeeIds", employeeIds.toString());
			request.setAttribute("employeeNames", employeeNames.toString());
			request.setAttribute("deviceIds", deviceIds.toString());
			request.setAttribute("deviceNames", deviceNames.toString());
			request.setAttribute("rentCounts", rentCounts.toString());
			request.setAttribute("meetingRoom", meetingRoom);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String deleteMeeting() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			Meeting meeting = meetingService.load(id);
			meetingService.deleteMeetingTranscation(meeting);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String uploadMeetingRecord() {
		return null;

	}

	public String downloadMeetingRecord() {
		return null;
	}

}
