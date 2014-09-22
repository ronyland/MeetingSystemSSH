/**
 * 
 */
package com.mms.enumeration;

/**
 * @author H
 * 
 */
public enum State {
	Allow, Disallow, Submit;

	public static final String ALLOW = "审核通过";
	public static final String DISALLOW = "审核失败";
	public static final String SUBMIT = "未审核";

	public static State enumOf(Integer value) {
		if (value == null) {
			return null;
		} else if (value == 0) {
			return Allow;
		} else if (value == 1) {
			return Disallow;
		} else {
			return Submit;
		}
	}

	public String getString() {
		if (this == Allow) {
			return ALLOW;
		} else if (this == Disallow) {
			return DISALLOW;
		} else {
			return SUBMIT;
		}
	}
}