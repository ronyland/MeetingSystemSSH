/**
 * 
 */
package com.mms.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.mms.criteria.Criteria;
import com.mms.domain.MeetingRoom;
import com.mms.enumeration.Time;
import com.mms.util.Pager;
import com.mms.util.ParamMap;
import com.mms.util.ReUtil;
import com.mms.util.Tuple;

/**
 * @author H
 * 
 */
public class MeetingRoomDao extends HibernateTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6378546717919110026L;

	@Override
	public Class<?> getClazz() {
		return MeetingRoom.class;
	}

	@Override
	public <C extends Criteria> Tuple<Query, Query> createQuery(C c, Pager pager) {
		ParamMap<String, Object> params = c.convertToMap();
		StringBuilder sql = new StringBuilder("from MeetingRoom mr where 1 = 1 ");
		StringBuilder sql2 = new StringBuilder("select count(*) from MeetingRoom mr where 1 = 1 ");
		if (!params.isKeyNotExistOrNull("address")) {
			sql.append("and mr.address like :address ");
			sql2.append("and mr.address like :address ");
		}
		if (!params.isKeyNotExistOrNull("maxCount")) {
			sql.append("and mr.maxCount >= :maxCount ");
			sql2.append("and mr.maxCount >= :maxCount ");
		}
		Query query = getSession().createQuery(sql.toString());
		Query query2 = getSession().createQuery(sql2.toString());
		if (!params.isKeyNotExistOrNull("address")) {
			query.setString("address", ReUtil.toRe((String) params.get("address")));
			query2.setString("address", ReUtil.toRe((String) params.get("address")));
		}
		if (!params.isKeyNotExistOrNull("maxCount")) {
			query.setInteger("maxCount", (Integer) params.get("maxCount"));
			query2.setInteger("maxCount", (Integer) params.get("maxCount"));
		}
		return new Tuple<Query, Query>(query, query2);
	}

	@SuppressWarnings("unchecked")
	public List<MeetingRoom> listLeisureMeetingRoom(Date date, Time time) {
		return getSession().getNamedQuery("listLeisureMeetingRoom").setDate("date", date).setInteger("time", time.ordinal()).list();
	}

}
