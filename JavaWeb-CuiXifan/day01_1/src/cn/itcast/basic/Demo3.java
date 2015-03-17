/*
 * 目的：学习使用JUnit的Test注解。
 * 说明：可以把测试方法当做main函数来用，绿条表示测试通过，红条表示测试不通过。
 * 注意：测试函数要做到：pulic\void\无参数。
 */
package cn.itcast.basic;

import org.junit.Test;

public class Demo3 {
	@Test
	public void func1() {
		System.out.println("哈哈");
	}

	@Test
	public void func2() {
		System.out.println("呵呵");
		throw new RuntimeException("错误");
	}

}
