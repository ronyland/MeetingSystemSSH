package com.mms.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.domain.Employee;
import com.mms.enumeration.Role;
import com.mms.service.IEmployeeService;

public class DefaultAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9175799518610031693L;

	@Autowired
	public IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String index() {
		return LOGIN;
	}

	public String login() {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Employee employee = employeeService.getByUsername(username);

			if (username.trim().isEmpty() || password.trim().isEmpty()) {
				throw new Exception();
			} else {
				if (employee == null) {
					throw new Exception();
				} else if (!password.equals(employee.getPassword())) {
					throw new Exception();
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("user", employee);
				}
			}
			if (employee.getRole() == Role.Admin) {
				return ADMIN;
			} else {
				return USER;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String logout() {
		request.getSession().setAttribute("user", null);
		return LOGOUT;
	}

}
