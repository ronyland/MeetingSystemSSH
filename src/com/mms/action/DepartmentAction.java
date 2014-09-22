package com.mms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.criteria.DepartmentCriteria;
import com.mms.domain.Department;
import com.mms.domain.Employee;
import com.mms.service.IDepartmentService;
import com.mms.util.Pager;
import com.mms.util.Validater;

public class DepartmentAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5552746623069076967L;

	@Autowired
	public IDepartmentService departmentService;

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String addDepartment() {
		try {
			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			} else {
				throw new Exception();
			}

			Department department = new Department();
			department.setName(name);
			departmentService.save(department);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String deleteDepartment() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			Department department = departmentService.load(id);
			departmentService.delete(department);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String searchDepartment() {
		try {
			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			}

			DepartmentCriteria departmentCriteria = new DepartmentCriteria();
			departmentCriteria.setName(name);

			Pager pager = pageChanged();

			List<Department> departments = departmentService.search(departmentCriteria, pager);

			request.setAttribute("name", name);

			if (name != null) {
				request.setAttribute("searching", true);
			} else {
				request.setAttribute("searching", false);
			}

			request.setAttribute("departments", departments);
			request.setAttribute("totalCount", departments.size());
			request.setAttribute("pager", pager);
			request.setAttribute("current", request.getServletPath());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String updateDepartment() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			}

			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			} else {
				throw new Exception();
			}

			Department department = new Department();
			department.setId(id);
			department.setName(name);
			departmentService.update(department);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String listDepartmentEmployee() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			List<Employee> employees = null;

			employees = departmentService.listDepartmentEmployees((Department) departmentService.load(id));

			StringBuilder sb = new StringBuilder();
			for (Employee employee : employees) {
				sb.append("<option id='employee_" + employee.getId() + "' value='" + employee.getId() + "'>" + employee.getName() + "</option>");
			}

			request.setAttribute("data", sb.toString());

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

}
