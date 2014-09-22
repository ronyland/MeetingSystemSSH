package com.mms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.criteria.EmployeeCriteria;
import com.mms.domain.Department;
import com.mms.domain.Employee;
import com.mms.enumeration.Role;
import com.mms.service.IDepartmentService;
import com.mms.service.IEmployeeService;
import com.mms.util.Pager;
import com.mms.util.Validater;

public class EmployeeAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8892783569046682721L;

	@Autowired
	public IEmployeeService employeeService;

	@Autowired
	public IDepartmentService departmentService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String deleteEmployee() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			Employee employee = employeeService.load(id);
			employeeService.delete(employee);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String searchEmployee() {
		try {
			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			}

			String username = null;
			if (!Validater.isEmptyOrNull(request.getParameter("username"))) {
				username = request.getParameter("username");
			}

			String department = null;
			if (!Validater.isEmptyOrNull(request.getParameter("department"))) {
				department = request.getParameter("department");
			}

			Long phone = null;
			if (Validater.isPhone(request.getParameter("phone"))) {
				phone = Long.valueOf(request.getParameter("phone"));
			}

			String email = null;
			if (!Validater.isEmptyOrNull(request.getParameter("email"))) {
				email = request.getParameter("email");
			}

			EmployeeCriteria employeeCriteria = new EmployeeCriteria();
			employeeCriteria.setName(name);
			employeeCriteria.setUsername(username);
			employeeCriteria.setPhone(phone);
			employeeCriteria.setEmail(email);
			employeeCriteria.setDepartmentName(department);

			Pager pager = pageChanged();

			List<Employee> employees = employeeService.search(employeeCriteria, pager);

			request.setAttribute("name", name);
			request.setAttribute("username", username);
			request.setAttribute("department", department);
			request.setAttribute("phone", phone);
			request.setAttribute("email", email);

			if (name != null || username != null || department != null || phone != null || email != null) {
				request.setAttribute("searching", true);
			} else {
				request.setAttribute("searching", false);
			}

			request.setAttribute("employees", employees);
			request.setAttribute("totalCount", employees.size());
			request.setAttribute("pager", pager);
			request.setAttribute("current", request.getServletPath());
			
			
			List<Department> departments = departmentService.list();
			request.setAttribute("departments", departments);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String updateEmployee() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			} else {
				throw new Exception();
			}

			String username = null;
			if (!Validater.isEmptyOrNull(request.getParameter("username"))) {
				username = request.getParameter("username");
			} else {
				throw new Exception();
			}
			
			String password = null;
			if (!Validater.isEmptyOrNull(request.getParameter("password"))) {
				password = request.getParameter("password");
			} else {
				throw new Exception();
			}

			int departmentId = 0;
			if (Validater.isInteger(request.getParameter("departmentId"))) {
				departmentId = Integer.valueOf(request.getParameter("departmentId"));
			} else {
				throw new Exception();
			}

			long phone = 0;
			if (Validater.isPhone(request.getParameter("phone"))) {
				phone = Long.valueOf(request.getParameter("phone"));
			} else {
				throw new Exception();
			}

			String email = null;
			if (!Validater.isEmptyOrNull(request.getParameter("email"))) {
				email = request.getParameter("email");
			} else {
				throw new Exception();
			}

			Employee employee = new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.setUsername(username);
			employee.setPassword(password);
			employee.setDepartment((Department) departmentService.load(departmentId));
			employee.setPhone(phone);
			employee.setRole(Role.User);
			employee.setEmail(email);
			employeeService.update(employee);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String addEmployee() {
		try {
			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			} else {
				throw new Exception();
			}

			String username = null;
			if (!Validater.isEmptyOrNull(request.getParameter("username"))) {
				username = request.getParameter("username");
			} else {
				throw new Exception();
			}
			
			String password = null;
			if (!Validater.isEmptyOrNull(request.getParameter("password"))) {
				password = request.getParameter("password");
			} else {
				throw new Exception();
			}

			int departmentId = 0;
			if (Validater.isInteger(request.getParameter("departmentId"))) {
				departmentId = Integer.valueOf(request.getParameter("departmentId"));
			} else {
				throw new Exception();
			}

			long phone = 0;
			if (Validater.isPhone(request.getParameter("phone"))) {
				phone = Long.valueOf(request.getParameter("phone"));
			} else {
				throw new Exception();
			}

			String email = null;
			if (!Validater.isEmptyOrNull(request.getParameter("email"))) {
				email = request.getParameter("email");
			} else {
				throw new Exception();
			}

			Employee employee = new Employee();
			employee.setName(name);
			employee.setUsername(username);
			employee.setPassword(password);
			employee.setDepartment((Department) departmentService.load(departmentId));
			employee.setPhone(phone);
			employee.setRole(Role.User);
			employee.setEmail(email);
			employeeService.save(employee);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
