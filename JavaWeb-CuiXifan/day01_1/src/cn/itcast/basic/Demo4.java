/*
 * 目的：联系JUnit的Before和After注解。
 * 说明：Before在测试方法之前执行，After在测试方法之后执行。
 */
package cn.itcast.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo4 {
	@Before
	public void before() {
		System.out.println("before()----------------------------");
	}
	@After
	public void after() {
		System.out.println("after()----------------------------");
	}

	@Test
	public void func1() {
		System.out.println("func1()");
	}

	@Test
	public void func2() {
		System.out.println("func2()");
	}
}
