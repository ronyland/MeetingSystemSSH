/**
 * 
 */
package com.mms.domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @author H
 * 
 */
public abstract class Domain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8438439812661137877L;

	public String format() {
		Class<? extends Domain> clazz = this.getClass();
		StringBuilder sb = new StringBuilder(clazz.getName() + " [");
		try {
			for (Field field : clazz.getDeclaredFields()) {
				if (!Modifier.isStatic(field.getModifiers())) {
					Object o = clazz.getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
							(Class<?>[]) null).invoke(this, (Object[]) null);
					sb.append(" " + o + " ");
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		sb.append("]");
		return sb.toString();
	}

}
