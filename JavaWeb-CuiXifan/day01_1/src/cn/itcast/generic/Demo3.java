/*
 * 目的：练习泛型类的继承
 * 说明：
 */
package cn.itcast.generic;

import org.junit.Test;

public class Demo3 {
	@Test
	public void func() {
		B<String> b = new B<String>();
		B1 b1 = new B1();
		B2<String> b2 = new B2<String>();
	}
}

//泛型类，父类
class B<T> {
	private T bean;

	public void setBean(T t) {
		bean = t;
	}

	public T getBean() {
		return bean;
	}
}

//情况一：
//子类不是泛型类，继承时可以给父类指定类型变量。
class B1 extends B<String> {
	@Override
	public void setBean(String t) {
		super.setBean(t);
	}
	@Override
	public String getBean() {
		return super.getBean();
	}
}

//情况二：
//子类也是泛型类，继承时可以用自己的类型变量给父类的类型变量赋值。
class B2<E> extends B<E> {
	@Override
	public void setBean(E t) {
		super.setBean(t);
	}

	@Override
	public E getBean() {
		return super.getBean();
	}
}