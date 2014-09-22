/**
 * 
 */
package com.mms.service;

import com.mms.domain.Employee;

/**
 * @author H
 * 
 */
public interface IEmployeeService extends IService {

	/**
	 * 通过员工用户名获取员工对象
	 * 
	 * @param name
	 * @return 员工对象
	 */
	public Employee getByUsername(String username);
}
