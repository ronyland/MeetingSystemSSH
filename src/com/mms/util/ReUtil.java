/**
 * 
 */
package com.mms.util;

/**
 * @author H
 * 
 */
public class ReUtil {

	public static String toRe(String re) {
		return "%%" + re.replace(" ", "%%") + "%%";
	}

}
