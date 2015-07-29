/**
 * 说明：学习反射泛型信息
 */
package cn.itcast.annotation;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class Demo1 {

	@Test
	public void fun1() {
		new B();
	}
}

abstract class A<T> {
	public A() {
		//获取子类的实际类型信息
		Class c = this.getClass();
		System.out.println(c);

		//获取子类的泛型信息
		Class c2 = this.getClass();							//获取子类的类型
		Type type = c2.getGenericSuperclass();				//获取子类的参数化类型，如A<String>
		ParameterizedType pType = (ParameterizedType)type;	//进行强转，还是A<String>
		Type[] types = pType.getActualTypeArguments();		//获取参数列表
		Class c3 = (Class)types[0];
		System.out.println(c3);

		//获取子类的泛型信息的简便写法
		Class c4 = (Class) ((ParameterizedType)this.getClass().
								getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println(c4);
	}
}

class B extends A<String> {
}

class C extends A<Integer> {
}