/**
 * 说明：学习反射注解信息
 * 
 * 注意：	1.要反射注解，必须把注解的@Retention声明为Runtime的。
 * 		2.反射不同的注解，用到不同的类。
 * 			反射类的注解，用Class
 * 			反射成员变量、构造函数、方法，分别使用Field、Constructor、Method
 */
package cn.itcast.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo2 {
	//反射类的注解信息
	@Test
	public void fun1() {
		Class<D> c = D.class;
		MyAnno21 myAnno21 = c.getAnnotation(MyAnno21.class);
		System.out.println(myAnno21.name()+","+myAnno21.age()+","+myAnno21.sex());
	}
	//反射方法的注解信息
	@Test
	public void fun2() throws NoSuchMethodException, SecurityException {
		Class<D> c = D.class;
		Method method = c.getMethod("fun1");
		MyAnno21 myAnno21 = method.getAnnotation(MyAnno21.class);
		System.out.println(myAnno21.name()+","+myAnno21.age()+","+myAnno21.sex());
	}
}

//使用注解
@MyAnno21(name="zhangsan", age=23, sex="male")
class D {
	@MyAnno21(name="lisi", age=32, sex="female")
	public void fun1() {
	}
}

//定义注解
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno21 {
	String name();
	int age();
	String sex();
}