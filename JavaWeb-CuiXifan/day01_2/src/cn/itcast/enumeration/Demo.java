/*
 * 目的：讲解enum的使用
 * 说明：enum就是多例模式。
 */
package cn.itcast.enumeration;

import org.junit.Test;

public class Demo {

	// enum的一些方法
	@Test
	public void func() {
		MyEnum e = MyEnum.C;
		MyEnum e2 = MyEnum.valueOf("B");

		System.out.println(e.name());
	}

	// enum配合switch使用
	@Test
	public void func2() throws ClassNotFoundException {
		MyEnum e = MyEnum.A;
		switch (e) {
		case A:
			System.out.println("A");
			break;
		case B:
			System.out.println("B");
			break;
		case C:
			System.out.println("C");
			break;
		}
		Class.forName("cn.itcast.enumeration.MyEnum2");
	}
}

//最简单的enum
enum ABC {
	A, B, C
}

//带构造函数的enum
enum MyEnum {
	A, B, C;

	MyEnum() {
	}
}

//带有参构造函数的enum
enum MyEnum2 {
	A("aaa"), B("bbb"), C("ccc");

	MyEnum2(String text) {
		System.out.println(text);
	}
}

//带有抽象方法的enum，构造时用 匿名内部类 来进行
enum MyEnum3 {
	A() {
		public void func() {}
	},
	B() {
		public void func() {}
	},
	C() {
		public void func() {}
	};

	public abstract void func();
}

// 不用enum来实现多例模式
class Multition {
	public static final Multition A = new Multition();
	public static final Multition B = new Multition();
	public static final Multition C = new Multition();

	private Multition() {
	}

	public void hello() {
		System.out.println("hello, world");
	}
}
