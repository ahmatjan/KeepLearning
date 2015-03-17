/*
 * 目的：练习使用Method。
 */
package cn.itcast.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo3 {
	//获得Method实例
	@Test
	public void func1() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class c = Class.forName("cn.itcast.reflect.Person");
		Method m = c.getMethod("setName", String.class);		//获得本类或父类中指定的 public Method
		Method[] ms = c.getMethods();											//获得本类或父类中所有的 public Method
		Method m2 = c.getDeclaredMethod("setAge", int.class);	//获得本类或父类中指定的  Method
		Method[] ms2 = c.getDeclaredMethods();										//获得本类或父类中指定的  Method
	}

	//常用的Method的方法
	@Test
	public void func2() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Method m = Class.forName("cn.itcast.reflect.Person").getMethod("setName", String.class);
		System.out.println(m.getName());
		m.getDeclaringClass();
		m.getParameterTypes();
		m.getExceptionTypes();
		m.getReturnType();
	}

	//用Method进行方法调用
	@Test
	public void func3() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c = Class.forName("cn.itcast.reflect.Person");
		Constructor con = c.getConstructor(String.class, int.class, String.class);
		Person p = (Person) con.newInstance("ZhangSan", 18, "male");
		Method m = c.getMethod("toString");
		System.out.println(m.invoke(p));

		System.out.println(int.class == Integer.class);
	}
}
