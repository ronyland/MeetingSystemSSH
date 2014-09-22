/**
 * 
 */
package com.mms.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.domain.Department;
import com.mms.domain.Employee;
import com.mms.persistence.DepartmentDao;
import com.mms.service.IDepartmentService;

/**
 * @author H
 * 
 */
public class DepartmentService extends Service implements IDepartmentService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2490548400737779646L;

	@Autowired
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Employee> listDepartmentEmployees(Department department) {
		return departmentDao.listDepartmentEmployees(department);
	}

}
