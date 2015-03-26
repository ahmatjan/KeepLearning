package cn.itcast.utils;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {
	public static <T> T toBean(Map map, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
