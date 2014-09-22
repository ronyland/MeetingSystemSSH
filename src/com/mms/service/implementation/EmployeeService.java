/**
 * 
 */
package com.mms.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.domain.Employee;
import com.mms.persistence.EmployeeDao;
import com.mms.service.IEmployeeService;

/**
 * @author H
 * 
 */
public class EmployeeService extends Service implements IEmployeeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6098221312820506688L;

	@Autowired
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee getByUsername(String name) {
		return employeeDao.getByUsername(name);
	}
}
