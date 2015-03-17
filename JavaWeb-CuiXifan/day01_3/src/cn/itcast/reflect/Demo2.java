/*
 * 目的：练习Constructor的使用。
 */
package cn.itcast.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Demo2 {
	//得到类的Constructor
	@Test
	public void func1() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class c = Class.forName("cn.itcast.reflect.Person");
		Constructor con = c.getConstructor(String.class, int.class, String.class);	//得到指定的public Constructor
		Constructor[] cons = c.getConstructors();																	//得到所有的public Constructor
		Constructor con2 = c.getDeclaredConstructor();			//得到指定的Constructor
		Constructor[] cons2 = c.getDeclaredConstructors();	//得到所有的Constructor
	}

	//获取Constructor的常用方法
	@Test
	public void func2() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Constructor con = Class.forName("cn.itcast.reflect.Person").getConstructor();
		System.out.println(con.getName());
		System.out.println(con.getDeclaringClass());
		con.getParameterTypes();
		con.getExceptionTypes();
	}

	//Constructor创建实例
	@Test
	public void func3() throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor con = Class.forName("cn.itcast.reflect.Person").getConstructor();
		Person p = (Person) con.newInstance();
	}
}
