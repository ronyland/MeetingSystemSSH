/**
 * 
 */
package com.mms.enumeration;

/**
 * @author H
 * 
 */
public enum Time {
	Morning, Noon, Afternoon, Dusk, Night;

	public static final String MORNING = "上午";
	public static final String NOON = "中午";
	public static final String AFTERNOON = "下午";
	public static final String DUSK = "傍晚";
	public static final String NIGHT = "夜晚";

	public static Time enumOf(Integer value) {
		if (value == null) {
			return null;
		} else if (value == 0) {
			return Morning;
		} else if (value == 1) {
			return Noon;
		} else if (value == 2) {
			return Afternoon;
		} else if (value == 3) {
			return Dusk;
		} else if (value == 4) {
			return Night;
		} else {
			return null;
		}
	}

	public String getString() {
		if (this == Morning) {
			return MORNING;
		} else if (this == Noon) {
			return NOON;
		} else if (this == Afternoon) {
			return AFTERNOON;
		} else if (this == Dusk) {
			return DUSK;
		} else {
			return NIGHT;
		}
	}
}