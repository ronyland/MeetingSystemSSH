/**
 * 
 */
package com.mms.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.mms.criteria.Criteria;
import com.mms.domain.Device;
import com.mms.domain.Employee;
import com.mms.domain.Meeting;
import com.mms.domain.association.MeetingDeviceRent;
import com.mms.domain.association.MeetingInvitation;
import com.mms.enumeration.State;
import com.mms.enumeration.Time;
import com.mms.util.Pager;
import com.mms.util.ParamMap;
import com.mms.util.ReUtil;
import com.mms.util.Tuple;

/**
 * @author H
 * 
 */
public class MeetingDao extends HibernateTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 316831130083300779L;

	@Override
	public Class<?> getClazz() {
		return Meeting.class;
	}

	@Override
	public <C extends Criteria> Tuple<Query, Query> createQuery(C c, Pager pager) {
		ParamMap<String, Object> params = c.convertToMap();
		StringBuilder sql = null;
		StringBuilder sql2 = null;
		sql = new StringBuilder("select m from Meeting m inner join m.employees e where 1 = 1 ");
		sql2 = new StringBuilder("select count(m) from Meeting m inner join m.employees e where 1 = 1 ");
		if (params.getOrDefault("startDate", null) != null && params.getOrDefault("endDate", null) != null) {
			sql.append("and m.date between :startDate and :endDate ");
			sql2.append("and m.date between :startDate and :endDate ");
		}
		if (params.getOrDefault("info", null) != null) {
			sql.append("and m.info like :info ");
			sql2.append("and m.info like :info ");
		}
		if (params.getOrDefault("state", null) != null) {
			sql.append("and m.state = :state ");
			sql2.append("and m.state = :state ");
		}
		if (params.getOrDefault("startTime", null) != null && params.getOrDefault("endTime", null) != null) {
			sql.append("and m.time between :startTime and :endTime ");
			sql2.append("and m.time between :startTime and :endTime ");
		}
		if (params.getOrDefault("topic", null) != null) {
			sql.append("and m.topic like :topic ");
			sql2.append("and m.topic like :topic ");
		}
		if (params.getOrDefault("hostEmployeeName", null) != null) {
			sql.append("and m.hostEmployee.name like :hostEmployeeName ");
			sql2.append("and m.hostEmployee.name like :hostEmployeeName ");
		}
		if (params.getOrDefault("hostEmployeeId", null) != null) {
			sql.append("and m.hostEmployee.id = :hostEmployeeId ");
			sql2.append("and m.hostEmployee.id = :hostEmployeeId ");
		}
		if (params.getOrDefault("address", null) != null) {
			sql.append("and m.meetingRoom.address like :address ");
			sql2.append("and m.meetingRoom.address like :address ");
		}
		if (params.getOrDefault("address", null) != null) {
			sql.append("and e.id = :employeeId ");
			sql2.append("and e.id = :employeeId ");
		}
		Query query = getSession().createQuery(sql.toString());
		Query query2 = getSession().createQuery(sql2.toString());
		if (!params.isKeyNotExistOrNull("startDate") && !params.isKeyNotExistOrNull("endDate")) {
			query.setDate("startDate", (Date) params.get("startDate"));
			query.setDate("endDate", (Date) params.get("endDate"));
			query2.setDate("startDate", (Date) params.get("startDate"));
			query2.setDate("endDate", (Date) params.get("endDate"));
		}
		if (!params.isKeyNotExistOrNull("info")) {
			query.setString("info", ReUtil.toRe(((String) params.get("info"))));
			query2.setString("info", ReUtil.toRe(((String) params.get("info"))));

		}
		if (!params.isKeyNotExistOrNull("state")) {
			query.setInteger("state", (State.valueOf((String) params.get("state")).ordinal()));
			query2.setInteger("state", (State.valueOf((String) params.get("state")).ordinal()));
		}
		if (!params.isKeyNotExistOrNull("startTime") && !params.isKeyNotExistOrNull("endTime")) {
			query.setInteger("startTime", (Time.valueOf((String) params.get("startTime")).ordinal()));
			query.setInteger("endTime", (Time.valueOf((String) params.get("endTime")).ordinal()));
			query2.setInteger("startTime", (Time.valueOf((String) params.get("startTime")).ordinal()));
			query2.setInteger("endTime", (Time.valueOf((String) params.get("endTime")).ordinal()));
		}
		if (!params.isKeyNotExistOrNull("topic")) {
			query.setString("topic", ReUtil.toRe(((String) params.get("topic"))));
			query2.setString("topic", ReUtil.toRe(((String) params.get("topic"))));
		}
		if (!params.isKeyNotExistOrNull("hostEmployeeName")) {
			query.setString("hostEmployeeName", ReUtil.toRe(((String) params.get("hostEmployeeName"))));
			query2.setString("hostEmployeeName", ReUtil.toRe(((String) params.get("hostEmployeeName"))));
		}
		if (params.getOrDefault("hostEmployeeId", null) != null) {
			query.setInteger("hostEmployeeId", (Integer) params.get("hostEmployeeId"));
			query2.setInteger("hostEmployeeId", (Integer) params.get("hostEmployeeId"));
		}
		if (params.getOrDefault("address", null) != null) {
			query.setString("address", ReUtil.toRe(((String) params.get("address"))));
			query2.setString("address", ReUtil.toRe(((String) params.get("address"))));
		}
		if (params.getOrDefault("address", null) != null) {
			query.setInteger("employeeId", (Integer) params.get("employeeId"));
			query2.setInteger("employeeId", (Integer) params.get("employeeId"));
		}
		return new Tuple<Query, Query>(query, query2);
	}

	public void allowMeeting(Meeting meeting) {
		getSession().getNamedQuery("verifyMeeting").setInteger("state", State.Allow.ordinal()).setInteger("id", meeting.getId()).uniqueResult();
	}

	public void disallowMeeting(Meeting meeting) {
		getSession().getNamedQuery("verifyMeeting").setInteger("state", State.Disallow.ordinal()).setInteger("id", meeting.getId()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Meeting> noteMeeting(Employee employee) {
		return getSession().getNamedQuery("noteMeeting").setInteger("id", employee.getId()).setInteger("state", State.Allow.ordinal()).list();
	}

	public int noteMeetingCount(Employee employee) {
		return (Integer) getSession().getNamedQuery("noteMeetingCount").setInteger("id", employee.getId()).setInteger("state", State.Allow.ordinal())
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Meeting> noteVerifyMeeting() {
		return getSession().getNamedQuery("noteVerifyMeeting").setInteger("state", State.Submit.ordinal()).list();
	}

	public int noteVerifyMeetingCount() {
		return (Integer) getSession().getNamedQuery("noteVerifyMeetingCount").setInteger("state", State.Submit.ordinal()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Meeting> myMeeting(Employee employee) {
		return getSession().getNamedQuery("myMeeting").setInteger("id", employee.getId()).list();
	}

	public void saveTransaction(Meeting meeting, List<MeetingInvitation> meetingInvitations, List<MeetingDeviceRent> meetingDeviceRents) {
		Transaction tx = getSession().beginTransaction();
		try {
			// Meeting
			this.save(meeting);

			// MeetingInvitation
			for (MeetingInvitation meetingInvitation : meetingInvitations) {
				meetingInvitation.setMeeting(meeting);
				this.save(meetingInvitation);
			}

			// MeetingDeviceRent
			for (MeetingDeviceRent meetingDeviceRent : meetingDeviceRents) {
				meetingDeviceRent.setMeeting(meeting);
				Device device = meetingDeviceRent.getDevice();
				device.setLeisure(device.getLeisure() - meetingDeviceRent.getCount());
				this.update(device);
				this.save(meetingDeviceRent);
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException(e);
		}
	}

	public void updateTransaction(Meeting meeting, List<MeetingInvitation> meetingInvitations, List<MeetingDeviceRent> meetingDeviceRents) {
		Transaction tx = getSession().beginTransaction();
		try {
			// 删除旧MI
			for (Employee employee : meeting.getEmployees()) {
				MeetingInvitation meetingInvitation = new MeetingInvitation();
				meetingInvitation.setMeeting(meeting);
				meetingInvitation.setEmployee(employee);
				this.delete(meetingInvitation);
			}

			// 删除旧MDR
			for (Device device : meeting.getDevices()) {
				MeetingDeviceRent meetingDeviceRent = new MeetingDeviceRent();
				meetingDeviceRent.setMeeting(meeting);
				meetingDeviceRent.setDevice(device);
				device.setLeisure(device.getLeisure() + meetingDeviceRent.getCount());
				this.update(device);
				this.delete(meetingDeviceRent);
			}

			// 修改会议
			this.update(meeting);

			// 重新插入MI
			for (MeetingInvitation meetingInvitation : meetingInvitations) {
				this.save(meetingInvitation);
			}

			// 重新插入MDR
			for (MeetingDeviceRent meetingDeviceRent : meetingDeviceRents) {
				Device device = meetingDeviceRent.getDevice();
				device.setLeisure(device.getLeisure() - meetingDeviceRent.getCount());
				this.update(device);
				this.save(meetingDeviceRent);
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException();
		}
	}

	public void deleteTransaction(Meeting meeting) {
		Transaction tx = getSession().beginTransaction();
		try {
			// 删除旧MI
			for (Employee employee : meeting.getEmployees()) {
				MeetingInvitation meetingInvitation = new MeetingInvitation();
				meetingInvitation.setEmployee(employee);
				meetingInvitation.setMeeting(meeting);
				this.delete(meetingInvitation);
			}

			// 删除旧MDR
			for (Device device : meeting.getDevices()) {
				MeetingDeviceRent meetingDeviceRent = new MeetingDeviceRent();
				meetingDeviceRent.setDevice(device);
				meetingDeviceRent.setMeeting(meeting);
				device.setLeisure(device.getLeisure() - meetingDeviceRent.getCount());
				this.update(device);
				this.delete(meetingDeviceRent);
			}

			// 删除会议
			this.delete(meeting);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException();
		}
	}

}
