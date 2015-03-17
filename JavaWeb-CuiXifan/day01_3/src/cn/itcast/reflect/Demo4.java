/*
 * 目的：练习Field的使用。
 */
package cn.itcast.reflect;


import java.lang.reflect.Field;

import org.junit.Test;

public class Demo4 {
	//获得Field实例
	@Test
	public void func1() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class c = Class.forName("cn.itcast.reflect.Person");
		//Field f = c.getField("name");		//获得本类及父类中指定 public成员的实例
		Field[] fs = c.getFields();				//获得本类及父类中所有 public成员的实例
		Field f2 = c.getDeclaredField("name");		//获得本类中指定 成员的实例
		Field[] fs2 = c.getDeclaredFields();				//获得本类中所有 成员的实例
	}

	//Filed常用方法
	@Test
	public void func2() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class c = Class.forName("cn.itcast.reflect.Person");
		Field f = c.getDeclaredField("name");
		System.out.println(f.getName());
		System.out.println(f.getDeclaringClass());
		System.out.println(f.getType());
	}

	//使用Field实例
	@Test
	public void func3() throws Exception {
		Class c = Class.forName("cn.itcast.reflect.Person");
		Field f = c.getDeclaredField("name");
		Person user = new Person("ZhangSan", 18, "male");

		f.setAccessible(true);
		System.out.println(f.get(user));
		f.set(user, "LiSi");
		System.out.println((String)f.get(user));
	}
}
