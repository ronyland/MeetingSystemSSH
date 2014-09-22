/**
 * 
 */
package com.mms.service;

import java.util.List;

import com.mms.domain.Department;
import com.mms.domain.Employee;

/**
 * @author H
 * 
 */
public interface IDepartmentService extends IService {

	/**
	 * 获取部门的员工
	 * 
	 * @param department
	 *            目标部门
	 * @return
	 */
	public List<Employee> listDepartmentEmployees(Department department);

}
