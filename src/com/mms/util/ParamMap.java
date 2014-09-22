/**
 * 
 */
package com.mms.util;

import java.util.HashMap;

/**
 * @author H
 * 
 */
public class ParamMap<K, V> extends HashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7780628948643497190L;

	public boolean isKeyNotExistOrNull(Object key) {
		if (this.getOrDefault(key, null) != null) {
			return false;
		} else {
			return true;
		}
	}

	public V getOrDefault(Object key, V defaultValue) {
		return this.containsKey(key) ? (this.get(key) == null ? defaultValue : this.get(key)) : defaultValue;
	}
}
