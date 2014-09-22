/**
 * 
 */
package com.mms.util;

/**
 * @author H
 * 
 */
public class Validater {

	public static boolean isEmptyOrNull(String s) {
		if (s != null) {
			return isEmpty(s);
		} else {
			return true;
		}
	}

	public static boolean isEmpty(String s) {
		return s.trim().equals("");
	}

	public static boolean isInteger(String s) {
		if (s != null) {
			try {
				Integer.valueOf(s);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isLong(String s) {
		if (s != null) {
			try {
				Long.valueOf(s);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isPhone(String s) {
		if (isLong(s)) {
			if (Long.valueOf(s) > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
