/**
 * 
 */
package com.mms.enumeration;

/**
 * @author H
 * 
 */
public enum Role {
	Admin, User;

	public static final String ADMIN = "管理员";
	public static final String USER = "用户";

	public static Role enumOf(Integer value) {
		if (value == null) {
			return null;
		} else if (value == 0) {
			return Admin;
		} else {
			return User;
		}
	}

	public String getString() {
		if (this == Admin) {
			return ADMIN;
		} else {
			return USER;
		}
	}
}