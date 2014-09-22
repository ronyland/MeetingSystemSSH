/**
 * 
 */
package com.mms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Type;

/**
 * @author H
 * 
 */
@Entity
@Table(name = "device")
public class Device extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -682928228570604305L;

	static final Logger logger = LogManager.getLogger(Device.class.getName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Type(type = "string")
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Type(type = "integer")
	@Column(name = "count", nullable = false, length = 10)
	private int count;

	@Type(type = "integer")
	@Column(name = "leisure", nullable = false, length = 10)
	private int leisure;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLeisure() {
		return leisure;
	}

	public void setLeisure(int leisure) {
		this.leisure = leisure;
	}

}
