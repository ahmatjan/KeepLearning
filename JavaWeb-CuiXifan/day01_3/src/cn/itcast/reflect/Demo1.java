/*
 * 目的：练习Class的使用。
 */
package cn.itcast.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class Demo1 {
	//获取Class类的实例的三种方法
	@Test
	public void func1() throws ClassNotFoundException {
		Person p = new Person();

		Class c1 = Person.class;
		Class c2 = p.getClass();
		Class c3 = Class.forName("cn.itcast.reflect.Person");
	}

	//Class类的常用方法
	@Test
	public void func2() throws ClassNotFoundException {
		Class c = Class.forName("cn.itcast.reflect.Person");
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		System.out.println(c.getSuperclass().getName());

		if (c.isArray()) {
			System.out.println("c是数组类型");
		} else if (c.isAnnotation()) {
			System.out.println("c是注解类型");
		} else if (c.isEnum()) {
			System.out.println("c是枚举类型");
		} else if (c.isInterface()) {
			System.out.println("c是接口类型");
		} else if (c.isPrimitive()) {
			System.out.println("c是基本类型");
		} else if (c.isSynthetic()) {
			System.out.println("c是引用类型");
		}
	}

	//用Class类创建实例
	@Test
	public void func3() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class c = Class.forName("cn.itcast.reflect.Person");
		Person p = (Person)c.newInstance();
		System.out.println(p);
	}

	//通过配置文件创建对象
	@Test
	public void func4() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//把config.properties中的配置信息加载到props对象中
		Properties props = new Properties();
		InputStream in = Demo1.class.getClassLoader().getResourceAsStream("config.properties");
		props.load(in);

		//用Class创建实例
		Class c =Class.forName(props.getProperty("className"));
		Person p = (Person) c.newInstance();
		System.out.println(p);
	}
}






