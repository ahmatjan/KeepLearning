/*
 * 目的：练习泛型类的使用
 * 说明：
 * 		1. 创建对象时，给类型变量赋值。
 * 		2. 在泛型类的定义中，通常用T代表类型变量。
 * 		3. 类型变量可以做参数、返回值、定义成员变量。
 */
package cn.itcast.generic;

import org.junit.Test;

public class Demo1 {
	@Test
	public void func() {
		A<String> a1 = new A<String>();
		A<Integer> a2 = new A<Integer>();
	}
}

class A<T> {
	private T t;
	public A() {
	}

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}