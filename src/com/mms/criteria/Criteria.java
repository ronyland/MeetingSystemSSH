/**
 * 
 */
package com.mms.criteria;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import com.mms.util.ParamMap;

/**
 * @author H
 * 
 */
public abstract class Criteria {

	public ParamMap<String, Object> convertToMap() {
		ParamMap<String, Object> map = new ParamMap<String, Object>();
		Class<? extends Criteria> clazz = this.getClass();
		try {
			for (Field field : clazz.getDeclaredFields()) {
				if (!Modifier.isStatic(field.getModifiers())) {
					Object o = clazz.getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
							(Class<?>[]) null).invoke(this, (Object[]) null);
					if (o != null) {
						map.put(field.getName(), o);
					}
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
		return map;
	}
}
