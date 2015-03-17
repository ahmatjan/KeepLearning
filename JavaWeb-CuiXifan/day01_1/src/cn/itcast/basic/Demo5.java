/*
 * 目的：练习自动拆装箱
 */
package cn.itcast.basic;

import org.junit.Test;

public class Demo5 {
	//自动拆装箱
	@Test
	public void func1() {
		//自动拆箱
		int a = new Integer(100);
		System.out.println(a);

		//自动装箱
		Integer b = 100;
		System.out.println(b);
	}
	/*
	 * 实际执行代码：
        int a = (new Integer(100)).intValue();
        System.out.println(a);
        Integer b = Integer.valueOf(100);
        System.out.println(b);
	 */

	//BT面试题
	@Test
	public void func2() {
		Integer i1 = 100;
		Integer i2 = 100;
		Integer i3 = 200;
		Integer i4 = 200;
		System.out.println(i1 == i2);
		System.out.println(i3 == i4);
		/*
		 * 看源码可知，
		 * Integer内部有一个Integer[], 缓存了-128～+127范围内的Integer，当valueOf是范围内的数则直接返回，否则用new来创建。
		 */
	}
}