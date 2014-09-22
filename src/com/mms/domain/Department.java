/**
 * 
 */
package com.mms.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Type;

/**
 * @author H
 * 
 */
@Entity
@Table(name = "department")
@NamedQueries(value = { @NamedQuery(name = "listDepartmentEmployees", query = "select d.employees  from Department d where d.id = :id") })
public class Department extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2886826571495489175L;

	static final Logger logger = LogManager.getLogger(Department.class.getName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Type(type = "string")
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
