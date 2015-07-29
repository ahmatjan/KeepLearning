/**
 * 说明：回忆泛型类的使用
 */
package cn.itcast;

//泛型类
class A<T> {
	private T t;
	
	public T fun1() {
		return t;
	}

	public void fun2(T t) {
		this.t = t;
	}
}

//泛型类的继承：子类不是泛型类，父类的类型变量必须为常量
class AA1 extends A<Long> {}

//泛型类的继承：子类是泛型类，父类的类型变量可以为变量
class AA2<T> extends A<T> {}


public class Demo1 {

	public static void main(String[] args) {
		A<Integer> a = new A<Integer>();

		AA1 aa1 = new AA1();
		AA2<Double> aa2 = new AA2<Double>();
	}
}
