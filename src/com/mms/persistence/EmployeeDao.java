/**
 * 
 */
package com.mms.persistence;

import org.hibernate.Query;

import com.mms.criteria.Criteria;
import com.mms.domain.Employee;
import com.mms.util.Pager;
import com.mms.util.ParamMap;
import com.mms.util.ReUtil;
import com.mms.util.Tuple;

/**
 * @author H
 * 
 */
public class EmployeeDao extends HibernateTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1941276317110061685L;

	@Override
	public Class<?> getClazz() {
		return Employee.class;
	}

	@Override
	public <C extends Criteria> Tuple<Query, Query> createQuery(C c, Pager pager) {
		ParamMap<String, Object> params = c.convertToMap();
		StringBuilder sql = new StringBuilder("from Employee e where 1 = 1 ");
		StringBuilder sql2 = new StringBuilder("select count(*) from Employee e where 1 = 1 ");
		if (!params.isKeyNotExistOrNull("name")) {
			sql.append("and e.name like :name ");
			sql2.append("and e.name like :name ");
		}
		if (!params.isKeyNotExistOrNull("username")) {
			sql.append("and e.username like :username ");
			sql2.append("and e.username like :username ");
		}
		if (!params.isKeyNotExistOrNull("phone")) {
			sql.append("and e.phone like :phone ");
			sql2.append("and e.phone like :phone ");
		}
		if (!params.isKeyNotExistOrNull("email")) {
			sql.append("and e.email like :email ");
			sql2.append("and e.email like :email ");
		}
		if (!params.isKeyNotExistOrNull("departmentName")) {
			sql.append("and e.department.name like :departmentName ");
			sql2.append("and e.department.name like :departmentName ");
		}
		Query query = getSession().createQuery(sql.toString());
		Query query2 = getSession().createQuery(sql2.toString());
		if (!params.isKeyNotExistOrNull("name")) {
			query.setString("name", ReUtil.toRe(((String) params.get("name"))));
			query2.setString("name", ReUtil.toRe(((String) params.get("name"))));
		}
		if (!params.isKeyNotExistOrNull("username")) {
			query.setString("username", ReUtil.toRe(((String) params.get("username"))));
			query2.setString("username", ReUtil.toRe(((String) params.get("username"))));
		}
		if (!params.isKeyNotExistOrNull("phone")) {
			query.setString("phone", ReUtil.toRe(String.valueOf(params.get("phone"))));
			query2.setString("phone", ReUtil.toRe(String.valueOf(params.get("phone"))));
		}
		if (!params.isKeyNotExistOrNull("email")) {
			query.setString("email", ReUtil.toRe(((String) params.get("email"))));
			query2.setString("email", ReUtil.toRe(((String) params.get("email"))));
		}
		if (!params.isKeyNotExistOrNull("departmentName")) {
			query.setString("departmentName", ReUtil.toRe(((String) params.get("departmentName"))));
			query2.setString("departmentName", ReUtil.toRe(((String) params.get("departmentName"))));
		}
		return new Tuple<Query, Query>(query, query2);
	}

	public Employee getByUsername(String username) {
		return (Employee) getSession().getNamedQuery("getByUsername").setString("username", username).uniqueResult();
	}

}
