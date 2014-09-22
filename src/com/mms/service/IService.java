/**
 * 
 */
package com.mms.service;

import java.io.Serializable;
import java.util.List;

import com.mms.criteria.Criteria;
import com.mms.domain.Domain;
import com.mms.util.Pager;

/**
 * @author H
 * 
 */
public interface IService extends Serializable {

	/**
	 * 载入泛型领域对象（只能是与该Dao关联的实体）
	 * 
	 * @param id
	 *            泛型领域对象的Id（主键）
	 * @return 泛型领域对象
	 */
	public <D extends Domain> D load(int id);

	/**
	 * 保存泛型领域对象
	 * 
	 * @param d
	 *            泛型领域对象
	 */
	public <D extends Domain> int save(D d);

	/**
	 * 删除泛型领域对象
	 * 
	 * @param d
	 *            泛型领域对象
	 */
	public <D extends Domain> void delete(D d);

	/**
	 * 更新泛型领域对象
	 * 
	 * @param d
	 *            泛型领域对象
	 */
	public <D extends Domain> void update(D d);

	/**
	 * 获取所有的泛型领域对象（只能是与该Dao关联的实体）
	 * 
	 * @return 所有的泛型领域对象
	 */
	public <D extends Domain> List<D> list();

	/**
	 * 搜索泛型领域对象
	 * 
	 * @param c
	 *            泛型搜索条件
	 * @param pager
	 *            分页对象
	 * @return 符合条件的对象
	 */
	public <D extends Domain, C extends Criteria> List<D> search(C c, Pager pager);

}
