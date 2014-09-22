/**
 * 
 */
package com.mms.persistence;

import java.util.List;

import org.hibernate.Query;

import com.mms.criteria.Criteria;
import com.mms.domain.Department;
import com.mms.domain.Employee;
import com.mms.util.Pager;
import com.mms.util.ParamMap;
import com.mms.util.ReUtil;
import com.mms.util.Tuple;

/**
 * @author H
 * 
 */
public class DepartmentDao extends HibernateTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2275679227682688175L;

	@Override
	public Class<?> getClazz() {
		return Department.class;
	}

	@Override
	public <C extends Criteria> Tuple<Query, Query> createQuery(C c, Pager pager) {
		ParamMap<String, Object> params = c.convertToMap();
		StringBuilder sql = new StringBuilder("from Department d where 1 = 1 ");
		StringBuilder sql2 = new StringBuilder("select count(*) from Department d where 1 = 1 ");
		if (!params.isKeyNotExistOrNull("name")) {
			sql.append("and d.name like :name ");
			sql2.append("and d.name like :name ");
		}
		Query query = getSession().createQuery(sql.toString());
		Query query2 = getSession().createQuery(sql2.toString());
		if (!params.isKeyNotExistOrNull("name")) {
			query.setString("name", ReUtil.toRe(((String) params.get("name"))));
			query2.setString("name", ReUtil.toRe(((String) params.get("name"))));
		}
		return new Tuple<Query, Query>(query, query2);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listDepartmentEmployees(Department department) {
		return getSession().getNamedQuery("listDepartmentEmployees").setInteger("id", department.getId()).list();
	}
}
