/**
 * 
 */
package com.mms.service.implementation;

import java.util.List;

import com.mms.criteria.Criteria;
import com.mms.domain.Domain;
import com.mms.persistence.HibernateTemplate;
import com.mms.service.IService;
import com.mms.util.Pager;

/**
 * @author H
 * 
 */
public abstract class Service implements IService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 314621426023687927L;

	protected HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public <D extends Domain> D load(int id) {
		return hibernateTemplate.load(id);
	}

	@Override
	public <D extends Domain> int save(D d) {
		return hibernateTemplate.save(d);
	}

	@Override
	public <D extends Domain> void delete(D d) {
		hibernateTemplate.delete(d);
	}

	@Override
	public <D extends Domain> void update(D d) {
		hibernateTemplate.update(d);
	}

	@Override
	public <D extends Domain> List<D> list() {
		return hibernateTemplate.list();
	}

	@Override
	public <D extends Domain, C extends Criteria> List<D> search(C c, Pager pager) {
		return hibernateTemplate.search(c, pager);
	}

}
