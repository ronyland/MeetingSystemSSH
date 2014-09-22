/**
 * 
 */
package com.mms.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mms.criteria.Criteria;
import com.mms.domain.Domain;
import com.mms.util.Pager;
import com.mms.util.Tuple;

/**
 * @author H
 * 
 */
public abstract class HibernateTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 685413876787342141L;

	public abstract Class<?> getClazz();

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		if (sessionFactory == null) {
			this.sessionFactory = sessionFactory;
		}
	}

	public Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}

	@SuppressWarnings("unchecked")
	public <D extends Domain> D load(int id) {
		return (D) getSession().load(getClazz(), id);
	}

	@SuppressWarnings("unchecked")
	public <D extends Domain> D load(Class<?> clazz, int id) {
		return (D) getSession().load(clazz, id);
	}

	public <D extends Domain> int save(D d) {
		Transaction tx = getSession().beginTransaction();
		int id = (Integer) getSession().save(d);
		getSession().flush();
		tx.commit();
		return id;
	}

	public <D extends Domain> void delete(D d) {
		Transaction tx = getSession().beginTransaction();
		getSession().delete(d);
		getSession().flush();
		tx.commit();
	}

	public <D extends Domain> void update(D d) {
		Transaction tx = getSession().beginTransaction();
		getSession().update(d);
		getSession().flush();
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public <D extends Domain> List<D> list() {
		return getSession().createQuery("from " + getClazz().getName()).list();
	}

	@SuppressWarnings("unchecked")
	public <D extends Domain, C extends Criteria> List<D> search(C c, Pager pager) {
		return Query(c, pager).setFirstResult(pager.getFirstResult()).setMaxResults(pager.getSize()).list();
	}

	public <C extends Criteria> Query Query(C c, Pager pager) {
		Tuple<Query, Query> queryTuple = createQuery(c, pager);
		pager.setTotalCount(count(queryTuple.getSecondItem()));
		return queryTuple.getFirstItem();
	}

	public abstract <C extends Criteria> Tuple<Query, Query> createQuery(C c, Pager pager);

	public int count(Query query) {
		return ((Long) query.iterate().next()).intValue();
	}
}
