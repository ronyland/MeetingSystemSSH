/**
 * 
 */
package com.mms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Type;

import com.mms.enumeration.Role;

/**
 * @author H
 * 
 */
@Entity
@Table(name = "employee")
@NamedQueries(value = { @NamedQuery(name = "getByUsername", query = "from Employee e where e.username = :username") })
public class Employee extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2356946209134185684L;

	static final Logger logger = LogManager.getLogger(Employee.class.getName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Type(type = "string")
	@Column(name = "username", nullable = false, length = 255, unique = true)
	private String username;

	@Type(type = "string")
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "role", nullable = false, length = 1)
	private Role role;

	@Type(type = "string")
	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Type(type = "long")
	@Column(name = "phone", nullable = false, length = 20)
	private Long phone;

	@Type(type = "string")
	@Column(name = "email", nullable = false, length = 255)
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
