/*
 * 目的：学习可变参数。
 */
package cn.itcast.basic;

import org.junit.Test;

public class Demo6 {
	@Test
	public void func() {
		sum(new int[] {1, 2, 3, 4});
		sum2(1, 2, 3, 4);
		sum2(new int[] {1, 2, 3,4});
	}

	//求和方法：用数组做参数
	public static void sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

	//求和方法：用可变参数做参数
	//说明：可变参数其实就是一个数组类型，方法内唯一的区别是把"[]"换成了"..."
	public static void sum2(int... arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
